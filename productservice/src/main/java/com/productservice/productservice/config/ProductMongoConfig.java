package com.productservice.productservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = {"com.productservice.productservice.repository.Product"},
                        mongoTemplateRef = ProductMongoConfig.MONGO_TEMPLATE)
public class ProductMongoConfig {
    protected static final String MONGO_TEMPLATE = "productDBMongoTemplate";
}
