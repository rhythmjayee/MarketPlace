package com.apigateway.apigateway.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = {"com.apigateway.apigateway.repository.UserAuth"},
                        mongoTemplateRef = UserAuthMongoConfig.MONGO_TEMPLATE)
public class UserAuthMongoConfig {
    protected static final String MONGO_TEMPLATE = "userAuthDBMongoTemplate";
}
