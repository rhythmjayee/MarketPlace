package com.userservice.models;

class User {
    private String name;
    final private String userID;

    public User(String name, final String userID) {
        this.name = name;
        this.userID = userID;
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
