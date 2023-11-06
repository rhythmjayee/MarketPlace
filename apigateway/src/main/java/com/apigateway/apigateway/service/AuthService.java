package com.apigateway.apigateway.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apigateway.apigateway.model.AuthRequest;
import com.apigateway.apigateway.model.AuthResponse;

@Service
public class AuthService {
    private final JwtService jwtService;
    @Autowired
    public AuthService(JwtService jwtService) {
        this.jwtService = jwtService;
    }
    public AuthResponse register(AuthRequest authRequest) {
        String accessToken = jwtService.generate(authRequest.getEmail(), authRequest.getUserType());

        return new AuthResponse(accessToken);
    }
}
