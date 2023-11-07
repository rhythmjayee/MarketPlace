package com.sellerservice.sellerservice.model;

public class Product {
    final private String productID;
    final private String sellerID;
    private String productName;
    private String imageLink;
    private long productQuantity;

    public Product(String productName, String productID, String sellerID) {
        this.productName = productName;
        this.productID = productID;
        this.sellerID = sellerID;
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
