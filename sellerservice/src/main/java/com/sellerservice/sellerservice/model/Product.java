package com.sellerservice.sellerservice.model;

public class Product {
    private String productID;
    final private String sellerID;
    private String productName;
    private String productDescription;
    private String imageLink;
    private long productQuantity;

    public Product(String sellerID, String productName, String productDescription, long productQuantity) {
        this.sellerID = sellerID;
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.productDescription = productDescription;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public long getProductQuantity() {
        return productQuantity;
    }

    public void setQuantity(long productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getproductName() {
        return this.productName;
    }

    public void setName(String productName) {
        this.productName = productName;
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
        return "Product [productID=" + productID + ", sellerID=" + sellerID + ", productName=" + productName + ", imageLink="
                + imageLink + ", productQuantity=" + productQuantity + "]";
    }
    
}
