package com.userservice.models;

import java.util.List;

public class Buyer extends User {
    private List<Order> orders;

    public Buyer(String name, long ID) {
        super(name, ID);
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
