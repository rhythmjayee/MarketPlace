package com.apigateway.apigateway.repository.UserAuth;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.apigateway.apigateway.model.UserAuth;

public interface UserAuthRepository extends MongoRepository<UserAuth, String> {
    public UserAuth findByEmail(String email);
}