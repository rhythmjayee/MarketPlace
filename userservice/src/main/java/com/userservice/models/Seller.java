package com.userservice.models;

import java.util.List;

public class Seller extends User{
    private final long shopID;
    private List<Product> products;

    public Seller(String name, long ID) {
        super(name, ID);
        this.shopID = ID;
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

    public long getShopID() {
        return this.shopID;
    }    
}
