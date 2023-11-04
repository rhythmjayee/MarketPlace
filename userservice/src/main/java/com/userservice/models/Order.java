package com.userservice.models;

import java.util.List;

public class Order {
    private final long orderID;
    private final long buyerID;
    private final long sellerID;
    private double orderValue;
    private List<ProductItem> orderItems;

    public Order(long orderID, long buyerID, long sellerID, double orderValue, List<ProductItem> orderItems) {
        this.orderID = orderID;
        this.buyerID = buyerID;
        this.sellerID = sellerID;
        this.orderValue = orderValue;
        this.orderItems = orderItems;
    }

    public long getOrderID() {
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

    public long getBuyerID() {
        return this.buyerID;
    }
    
    public long getSellerID() {
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
