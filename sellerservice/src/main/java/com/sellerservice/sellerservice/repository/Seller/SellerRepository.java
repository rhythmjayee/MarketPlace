package com.sellerservice.sellerservice.repository.Seller;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sellerservice.sellerservice.model.Seller;

public interface SellerRepository extends MongoRepository<Seller, String> {
    public Optional<Seller> findByEmail(String email);
}

