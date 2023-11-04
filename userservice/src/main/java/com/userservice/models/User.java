package com.userservice.models;

class User {
    private String name;
    final private long ID;

    public User(String name, final long ID) {
        this.name = name;
        this.ID = ID;
    }

    public long getUserId() {
        return this.ID;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
