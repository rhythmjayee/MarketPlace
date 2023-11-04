package com.userservice.userservice.repository.seller;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.userservice.userservice.models.Seller;

public interface SellerRepository extends MongoRepository<Seller, String> {

    public Seller findByName(String name);
}
