package com.userservice.models;

import java.util.List;

public class Order {
    private final String orderID;
    private final String buyerID;
    private final String sellerID;
    private double orderValue;
    private List<ProductItem> orderItems;

    public Order(String orderID, String buyerID, String sellerID, double orderValue, List<ProductItem> orderItems) {
        this.orderID = orderID;
        this.buyerID = buyerID;
        this.sellerID = sellerID;
        this.orderValue = orderValue;
        this.orderItems = orderItems;
    }

    public String getOrderID() {
        return this.orderID;
    }

    public double getOrderValue() {
        return this.orderValue;
    }

    public void setOrderValue(double orderValue) {
        this.orderValue = orderValue;
    }

    public List<ProductItem> getOrderItems() {
        return this.orderItems;
    }

    public void setOrderItems(List<ProductItem> orderItems) {
        this.orderItems = orderItems;
    }

    public String getBuyerID() {
        return this.buyerID;
    }

    public String getSellerID() {
        return this.sellerID;
    }

    @Override
    public String toString() {
        return "{" +
            " orderID='" + getOrderID() + "'" +
            ", orderValue='" + getOrderValue() + "'" +
            ", orderItems='" + getOrderItems() + "'" +
            "}";
    }

}
