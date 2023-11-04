package com.userservice.models;

import java.util.List;

public class Seller extends User{
    private final String shopID;
    private List<Product> products;

    public Seller(String name, String sellerID) {
        super(name, sellerID);
        this.shopID = sellerID;
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
}
