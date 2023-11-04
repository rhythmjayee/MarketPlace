package com.userservice.models;

public class Product {
    private String name;
    private String imageLink;
    final private String productID;
    final private String sellerID;

    public Product(String name, String productID, String sellerID) {
        this.name = name;
        this.productID = productID;
        this.sellerID = sellerID;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageLink() {
        return this.imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public String getProductID() {
        return this.productID;
    }    

    public String getSellerID() {
        return this.sellerID;
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", imageLink='" + getImageLink() + "'" +
            ", ID='" + getProductID() + "'" +
            ", sellerID='" + getSellerID() + "'" +
            "}";
    }
    
}
