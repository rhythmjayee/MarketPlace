package com.userservice.userservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.userservice.userservice.repository.seller",
                        mongoTemplateRef = SellerMongoConfig.MONGO_TEMPLATE)
public class SellerMongoConfig {
    protected static final String MONGO_TEMPLATE = "sellerDBMongoTemplate";
}
