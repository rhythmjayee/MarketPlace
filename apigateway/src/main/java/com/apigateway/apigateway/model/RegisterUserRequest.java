package com.apigateway.apigateway.model;

public class RegisterUserRequest extends AuthRequest {
    private String name;

    public RegisterUserRequest(String name, String email, String password, String userType) {
        super(email, password, userType);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            " email='" + getEmail() + "'" +
            "}";
    }
    
}
