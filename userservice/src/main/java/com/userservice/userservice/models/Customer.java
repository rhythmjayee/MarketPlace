package com.userservice.userservice.models;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customer")
public class Customer extends User {
    private List<Order> orders;

    public Customer(String name) {
        super(name);
    }
    public List<Order> getOrders() {
        return this.orders;
    }
    public void addNewOrder(Order order) {
        orders.add(order);
    }
    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
