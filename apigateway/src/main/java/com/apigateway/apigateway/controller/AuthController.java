package com.apigateway.apigateway.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apigateway.apigateway.model.AuthRequest;
import com.apigateway.apigateway.model.AuthResponse;
import com.apigateway.apigateway.model.Customer;
import com.apigateway.apigateway.model.RegisterUserRequest;
import com.apigateway.apigateway.model.Seller;
import com.apigateway.apigateway.model.UserAuth;
import com.apigateway.apigateway.repostiory.Customer.CustomerRepository;
import com.apigateway.apigateway.repostiory.Seller.SellerRepository;
import com.apigateway.apigateway.repostiory.UserAuth.UserAuthRepository;
import com.apigateway.apigateway.service.AuthService;
import com.apigateway.apigateway.utils.PasswordEncoder;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {

    private final AuthService authService;
    private UserAuthRepository userAuthRepository;
	private CustomerRepository customerRepository;
    private SellerRepository sellerRepository;

    public AuthController(AuthService authService, UserAuthRepository userAuthRepository,
            CustomerRepository customerRepository, SellerRepository sellerRepository) {
        this.authService = authService;
        this.userAuthRepository = userAuthRepository;
        this.customerRepository = customerRepository;
        this.sellerRepository = sellerRepository;
    }

    @Transactional
    private void saveUserInDBs(RegisterUserRequest registerUserRequest) {
        String hashPassword = PasswordEncoder.bcryptPasswordEncode(registerUserRequest.getPassword());
        UserAuth usr = new UserAuth(registerUserRequest.getEmail(), hashPassword, registerUserRequest.getUserType());
        userAuthRepository.save(usr);
        if(registerUserRequest.getUserType().equals("customer")) {
            Customer customer = new Customer(registerUserRequest.getName(), registerUserRequest.getEmail());
            customerRepository.save(customer);
        } else {
            Seller seller = new Seller(registerUserRequest.getName(), registerUserRequest.getEmail());
            sellerRepository.save(seller);
        }
    }

    @PostMapping(value = "/register")
    public ResponseEntity<Object> register(@RequestBody RegisterUserRequest registerUserRequest) {
        UserAuth usr = userAuthRepository.findByEmail(registerUserRequest.getEmail());
        if(usr != null) {
            return ResponseEntity.badRequest().body("User Already Exist");
        }
        saveUserInDBs(registerUserRequest);
        return ResponseEntity.ok(authService.getAuthToken(registerUserRequest));
    }

    @PostMapping(value = "/login")
    public ResponseEntity<Object> login(@RequestBody AuthRequest authRequest) {
        UserAuth usr = userAuthRepository.findByEmail(authRequest.getEmail());
        if(usr == null) {
            return ResponseEntity.badRequest().body("User Doesn't Exist");
        }
        String savedPass = usr.getPassword();
        boolean isPassMatched = PasswordEncoder.bcryptPasswordMatch(authRequest.getPassword(), savedPass);
        if(!isPassMatched) {
            return ResponseEntity.badRequest().body("User Password Incorrect");
        }
        return ResponseEntity.ok(authService.getAuthToken(authRequest));
    }
}
