package com.userservice.userservice.config;

import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.MongoClientFactoryBean;
import org.springframework.data.mongodb.core.MongoTemplate;

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
    public MongoClientFactoryBean customerMongoClientFactoryBean(MongoProperties mongoProperties) {
        MongoClientFactoryBean factoryBean = new MongoClientFactoryBean();
        factoryBean.setHost(mongoProperties.getHost());
        factoryBean.setPort(mongoProperties.getPort());
        factoryBean.setCredential(new MongoCredential[]{
            MongoCredential.createCredential(
                mongoProperties.getUsername(),
                mongoProperties.getDatabase(),
                mongoProperties.getPassword())
        });
        return factoryBean;
    }

    @Bean
    public MongoClientFactoryBean sellerMongoClientFactoryBean(MongoProperties mongoProperties) {
        MongoClientFactoryBean factoryBean = new MongoClientFactoryBean();
        factoryBean.setHost(mongoProperties.getHost());
        factoryBean.setPort(mongoProperties.getPort());
        factoryBean.setCredential(new MongoCredential[]{
            MongoCredential.createCredential(
                mongoProperties.getUsername(),
                mongoProperties.getDatabase(),
                mongoProperties.getPassword())
        });
        return factoryBean;
    }
    @Primary
    @Bean(name = "customerDBMongoTemplate")
    public MongoTemplate customerMongoTemplate(MongoClient customerMongoClient, MongoProperties mongoProperties) {
        return new MongoTemplate(customerMongoClient, mongoProperties.getDatabase());
    }

    @Bean(name = "sellerDBMongoTemplate")
    public MongoTemplate sellerMongoTemplate(MongoClient sellerMongoClient, MongoProperties mongoProperties) {
        return new MongoTemplate(sellerMongoClient, mongoProperties.getDatabase());
    }
}
