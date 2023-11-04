package com.userservice.userservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = {"com.userservice.userservice.repository.customer"},
                        mongoTemplateRef = CustomerMongoConfig.MONGO_TEMPLATE)
public class CustomerMongoConfig {
    protected static final String MONGO_TEMPLATE = "customerDBMongoTemplate";
}
