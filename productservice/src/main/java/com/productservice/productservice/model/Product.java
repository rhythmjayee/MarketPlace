package com.productservice.productservice.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
@Document(collection = "product")
public class Product {
    @MongoId
    private String productID;
    final private String sellerID;
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
