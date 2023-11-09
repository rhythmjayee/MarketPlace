package com.sellerservice.sellerservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {
    private String productID;
    private String sellerID;
    private String productName;
    private String imageLink;
    private long productQuantity;
    private String productDescription;

    public Product(String sellerID, String productName, String productDescription, long productQuantity) {
        this.sellerID = sellerID;
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.productDescription = productDescription;
    }
}
