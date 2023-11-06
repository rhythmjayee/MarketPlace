package com.apigateway.apigateway.model;
import java.util.Objects;

public class RegisterUserRequest extends AuthRequest {
    private String name;

    public RegisterUserRequest(String name) {
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
