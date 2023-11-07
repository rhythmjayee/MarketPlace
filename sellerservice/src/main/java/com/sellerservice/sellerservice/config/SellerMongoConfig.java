package com.sellerservice.sellerservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = {"com.sellerservice.sellerservice.repository.Seller"},
                        mongoTemplateRef = SellerMongoConfig.MONGO_TEMPLATE)
public class SellerMongoConfig {
    protected static final String MONGO_TEMPLATE = "sellerDBMongoTemplate";
}
