package com.apigateway.apigateway.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = {"com.apigateway.apigateway.repository.Seller"},
                        mongoTemplateRef = SellerMongoConfig.MONGO_TEMPLATE)
public class SellerMongoConfig {
    protected static final String MONGO_TEMPLATE = "sellerDBMongoTemplate";
}
