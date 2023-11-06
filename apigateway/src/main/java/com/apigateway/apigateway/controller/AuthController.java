package com.apigateway.apigateway.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apigateway.apigateway.model.AuthRequest;
import com.apigateway.apigateway.model.AuthResponse;
import com.apigateway.apigateway.model.User;
import com.apigateway.apigateway.service.AuthService;
import com.apigateway.apigateway.utils.PasswordEncoder;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {

    private final AuthService authService;
    private static final Map<String, User> userDB = new HashMap<>();
    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping(value = "/register")
    public ResponseEntity<Object> register(@RequestBody AuthRequest authRequest) {
        if(userDB.containsKey(authRequest.getEmail())) {
            return ResponseEntity.badRequest().body("User Already Exist");
        }
        String hashPassword = PasswordEncoder.bcryptPasswordEncode(authRequest.getPassword());
        User usr =  new User(authRequest.getEmail(), hashPassword, authRequest.getUserType());
        userDB.put(authRequest.getEmail(), usr);
        return ResponseEntity.ok(authService.register(authRequest));
    }

    @PostMapping(value = "/login")
    public ResponseEntity<Object> login(@RequestBody AuthRequest authRequest) {
        if(!userDB.containsKey(authRequest.getEmail())) {
            return ResponseEntity.badRequest().body("User Doesnot Exist");
        }
        String savedPass = userDB.get(authRequest.getEmail()).getPassword();
        boolean isPassMatched = PasswordEncoder.bcryptPasswordMatch(authRequest.getPassword(), savedPass);
        if(!isPassMatched) {
            return ResponseEntity.badRequest().body("User Password Incorrect");
        }
        return ResponseEntity.ok(authService.login(authRequest));
    }
}
