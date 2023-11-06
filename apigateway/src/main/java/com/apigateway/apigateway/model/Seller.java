package com.apigateway.apigateway.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "seller")
public class Seller extends User{

    public Seller(String name, String email) {
        super(name, email);
    }

    @Override
    public String toString() {
        return "{" +
            " shopID='" + getUserID() + "'" +
            ", sellerName='" + getName() + "'" +
            ", sellerEmail='" + getEmail() + "'" +
            "}";
    }

}
