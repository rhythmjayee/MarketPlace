package com.userservice.userservice.models;

public class ProductItem {
    private long quantity;
    private Product product;
    private double productItemPrice;

    public ProductItem() {
    }

    public ProductItem(long quantity, Product product, double productItemPrice) {
        this.quantity = quantity;
        this.product = product;
        this.productItemPrice = productItemPrice;
    }

    public long getQuantity() {
        return this.quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getProductItemPrice() {
        return this.productItemPrice;
    }

    public void setProductItemPrice(double productItemPrice) {
        this.productItemPrice = productItemPrice;
    }

    @Override
    public String toString() {
        return "{" +
            " quantity='" + getQuantity() + "'" +
            ", product='" + getProduct() + "'" +
            "}";
    }
    
}
