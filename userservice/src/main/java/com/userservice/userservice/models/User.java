package com.userservice.userservice.models;

import org.springframework.data.mongodb.core.mapping.MongoId;

class User {
    private String name;
    @MongoId
    private String userID;

    public User(String name) {
        this.name = name;
    }

    public String getUserId() {
        return this.userID;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
