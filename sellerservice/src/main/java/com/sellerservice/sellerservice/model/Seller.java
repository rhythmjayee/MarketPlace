package com.sellerservice.sellerservice.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "seller")
public class Seller extends User{
    private List<String> listedProductIDs;

    public Seller(String name, String email) {
        super(name, email);
    }

    public int addProduct(String productID) {
        this.listedProductIDs.add(productID);
        return 1;
    }
    public List<String> getListedProductIDs() {
        return listedProductIDs;
    }

    public void setListedProductIDs(List<String> listedProductIDs) {
        this.listedProductIDs = listedProductIDs;
    }

    @Override
    public String toString() {
        return "{" +
            " shopID='" + getUserID() + "'" +
            ", sellerName='" + getName() + "'" +
            ", sellerEmail='" + getEmail() + "'" +
            ", listedProductIDs='" + getListedProductIDs() + "'" +
            "}";
    }
}
