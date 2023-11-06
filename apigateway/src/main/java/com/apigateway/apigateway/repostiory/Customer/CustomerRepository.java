package com.apigateway.apigateway.repostiory.Customer;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.apigateway.apigateway.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String> {

}
