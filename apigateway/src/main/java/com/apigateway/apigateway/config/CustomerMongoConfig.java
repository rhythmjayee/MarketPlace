package com.apigateway.apigateway.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = {"com.apigateway.apigateway.repository.Customer"},
                        mongoTemplateRef = CustomerMongoConfig.MONGO_TEMPLATE)
public class CustomerMongoConfig {
    protected static final String MONGO_TEMPLATE = "customerDBMongoTemplate";
}
