package com.userservice.userservice.models;

import java.util.List;

public class Seller extends User{
    private String shopID;
    private List<Product> products;

    public Seller(String name) {
        super(name);
    }

    public void addNewProduct(Product product) {
        products.add(product);
    }
    public List<Product> getProducts() {
        return this.products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getShopID() {
        return this.shopID;
    } 

    @Override
    public String toString() {
        return "{" +
            " shopID='" + getShopID() + "'" +
            ", products='" + getProducts() + "'" +
            "}";
    }

}
