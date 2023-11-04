package com.userservice.userservice.config;

import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoClientFactoryBean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

import com.mongodb.MongoCredential;
import com.mongodb.client.MongoClient;

@Configuration
public class MongoConfig {

    @Primary
    @Bean(name = "customerDBProperties")
    @ConfigurationProperties(prefix = "spring.data.mongodb.primary")
    public MongoProperties customerMongoProperties() {
        return new MongoProperties();
    }

    @Bean(name = "sellerDBProperties")
    @ConfigurationProperties(prefix = "spring.data.mongodb.secondary")
    public MongoProperties sellerMongoProperties() {
        return new MongoProperties();
    }

    @Primary
    @Bean
    public MongoDatabaseFactory customerMongoDatabaseFactoryBean(MongoProperties mongoProperties) {
        return new SimpleMongoClientDatabaseFactory(
                mongoProperties.getUri()
        );
    }

    @Bean
    public MongoDatabaseFactory sellerMongoDatabaseFactoryBean(MongoProperties mongoProperties) {
        return new SimpleMongoClientDatabaseFactory(
                mongoProperties.getUri()
        );
    }
    @Primary
    @Bean(name = "customerDBMongoTemplate")
    public MongoTemplate customerMongoTemplate() {
        return new MongoTemplate(customerMongoDatabaseFactoryBean(customerMongoProperties()));
    }

    @Bean(name = "sellerDBMongoTemplate")
    public MongoTemplate sellerMongoTemplate() {
        return new MongoTemplate(sellerMongoDatabaseFactoryBean(sellerMongoProperties()));
    }
}
