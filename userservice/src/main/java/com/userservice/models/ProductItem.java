package com.userservice.models;

public class ProductItem {
    private long quantity;
    private Product product;

    public ProductItem() {
    }

    public ProductItem(long quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
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

    @Override
    public String toString() {
        return "{" +
            " quantity='" + getQuantity() + "'" +
            ", product='" + getProduct() + "'" +
            "}";
    }
    
}
