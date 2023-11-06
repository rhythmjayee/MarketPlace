package com.apigateway.apigateway.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customer")
public class Customer extends User {

    public Customer(String name, String email) {
        super(name, email);
    }
    @Override
    public String toString() {
        return "{" +
            "userId=" + getUserID() +"'"+
            " userName='" + getName() + "'" +
            " userEmail='" + getEmail() + "'" +
            "}";
    }

}
