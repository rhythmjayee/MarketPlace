package com.userservice.models;

public class Product {
    private String name;
    private String imageLink;
    final private long productID;
    final private long sellerID;

    public Product(String name, long productID, long sellerID) {
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

    public long getProductID() {
        return this.productID;
    }    

    public long getSellerID() {
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
