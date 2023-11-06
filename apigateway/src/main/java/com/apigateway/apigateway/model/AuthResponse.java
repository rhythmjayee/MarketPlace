package com.apigateway.apigateway.model;

public class AuthResponse {
    private String jwtAccessToken;

    public AuthResponse() {
    }

    public AuthResponse(String jwtAccessToken) {
        this.jwtAccessToken = jwtAccessToken;
    }

    public String getJwtToken() {
        return this.jwtAccessToken;
    }

    public void setJwtToken(String jwtAccessToken) {
        this.jwtAccessToken = jwtAccessToken;
    }
    @Override
    public String toString() {
        return "{" +
            " jwtAccessToken='" + getJwtToken() + "'" +
            "}";
    }
    
}
