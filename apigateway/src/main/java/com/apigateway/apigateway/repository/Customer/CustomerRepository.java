package com.apigateway.apigateway.repository.Customer;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.apigateway.apigateway.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String> {

}
