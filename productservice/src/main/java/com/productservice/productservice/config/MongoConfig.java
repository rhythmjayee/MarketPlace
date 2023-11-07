package com.productservice.productservice.config;

import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.mongodb.SessionSynchronization;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

@Configuration
public class MongoConfig {
    @Primary
    @Bean(name = "productDBProperties")
    @ConfigurationProperties(prefix = "spring.data.mongodb.product")
    public MongoProperties productMongoProperties() {
        return new MongoProperties();
    }

    @Primary
    @Bean
    public MongoDatabaseFactory productMongoDatabaseFactory(MongoProperties mongoProperties) {
        return new SimpleMongoClientDatabaseFactory(
                mongoProperties.getUri()
        );
    }

    @Primary
    @Bean
    public MongoTransactionManager productMongoTransactionManager() {
        return new MongoTransactionManager(productMongoDatabaseFactory(productMongoProperties()));
    }

    @Primary
    @Bean(name = "productDBMongoTemplate")
    public MongoTemplate productMongoTemplate() {
        MongoTemplate mongoTemplate = new MongoTemplate(productMongoDatabaseFactory(productMongoProperties()));
        mongoTemplate.setSessionSynchronization(SessionSynchronization.ON_ACTUAL_TRANSACTION);
        return mongoTemplate;
    }
}
