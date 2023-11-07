package com.sellerservice.sellerservice.config;

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
    @Bean(name = "sellerDBProperties")
    @ConfigurationProperties(prefix = "spring.data.mongodb.seller")
    public MongoProperties sellerMongoProperties() {
        return new MongoProperties();
    }

    @Primary
    @Bean
    public MongoDatabaseFactory sellerMongoDatabaseFactory(MongoProperties mongoProperties) {
        return new SimpleMongoClientDatabaseFactory(
                mongoProperties.getUri()
        );
    }

    @Primary
    @Bean
    public MongoTransactionManager sellerMongoTransactionManager() {
        return new MongoTransactionManager(sellerMongoDatabaseFactory(sellerMongoProperties()));
    }

    @Primary
    @Bean(name = "sellerDBMongoTemplate")
    public MongoTemplate sellerMongoTemplate() {
        MongoTemplate mongoTemplate = new MongoTemplate(sellerMongoDatabaseFactory(sellerMongoProperties()));
        mongoTemplate.setSessionSynchronization(SessionSynchronization.ON_ACTUAL_TRANSACTION);
        return mongoTemplate;
    }
}
