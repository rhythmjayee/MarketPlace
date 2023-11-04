package com.userservice.userservice.repository.customer;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.userservice.userservice.models.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String> {

    public Customer findByName(String name);
}
