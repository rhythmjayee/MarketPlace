package com.sellerservice.sellerservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.base.Optional;
import com.sellerservice.sellerservice.model.Seller;
import com.sellerservice.sellerservice.service.SellerProfileService;

@RestController
@RequestMapping(value = "/seller/profile")
public class SellerProfileController {
    private final SellerProfileService sellerProfileService;

    public SellerProfileController(SellerProfileService sellerProfileService) {
        this.sellerProfileService = sellerProfileService;
    }
    
    @GetMapping(value = "/details")
    @ResponseBody
    public ResponseEntity<Object> getSellerDetails(@RequestParam("email") String email) {
        Optional<String> optionalEmail = Optional.of(email);
        ResponseEntity<Object> rs = ResponseEntity.badRequest().body("Seller Not Found");
        if(!optionalEmail.isPresent()) return rs;
        Seller seller = sellerProfileService.getSellerDetailsByEmail(optionalEmail.get());
        if(seller == null) return rs;
        return ResponseEntity.ok(seller);
    }
}
