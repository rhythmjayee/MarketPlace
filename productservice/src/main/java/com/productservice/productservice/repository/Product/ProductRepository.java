package com.productservice.productservice.repository.Product;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.productservice.productservice.model.Product;

public interface ProductRepository extends MongoRepository<Product, String>{
    @Query(value="{sellerID : ?0}")    
    List<Product> findAllProductsBySellerID(String sellerID);
}