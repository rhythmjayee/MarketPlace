package com.apigateway.apigateway.repostiory.Seller;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.apigateway.apigateway.model.Seller;

public interface SellerRepository extends MongoRepository<Seller, String> {

}
