package com.apigateway.apigateway.config;

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
    @Bean(name = "userAuthDBProperties")
    @ConfigurationProperties(prefix = "spring.data.mongodb.user-auth")
    public MongoProperties userAuthMongoProperties() {
        return new MongoProperties();
    }

    @Bean(name = "customerDBProperties")
    @ConfigurationProperties(prefix = "spring.data.mongodb.customer")
    public MongoProperties customerMongoProperties() {
        return new MongoProperties();
    }

    @Bean(name = "sellerDBProperties")
    @ConfigurationProperties(prefix = "spring.data.mongodb.seller")
    public MongoProperties sellerMongoProperties() {
        return new MongoProperties();
    }

    @Primary
    @Bean
    public MongoDatabaseFactory userAuthMongoDatabaseFactory(MongoProperties mongoProperties) {
        return new SimpleMongoClientDatabaseFactory(
                mongoProperties.getUri()
        );
    }

    @Bean
    public MongoDatabaseFactory customerMongoDatabaseFactory(MongoProperties mongoProperties) {
        return new SimpleMongoClientDatabaseFactory(
                mongoProperties.getUri()
        );
    }

    @Bean
    public MongoDatabaseFactory sellerMongoDatabaseFactory(MongoProperties mongoProperties) {
        return new SimpleMongoClientDatabaseFactory(
                mongoProperties.getUri()
        );
    }

    @Primary
    @Bean
    public MongoTransactionManager userAuthMongoTransactionManager() {
        return new MongoTransactionManager(userAuthMongoDatabaseFactory(userAuthMongoProperties()));
    }

    @Bean
    public MongoTransactionManager customerMongoTransactionManager() {
        return new MongoTransactionManager(userAuthMongoDatabaseFactory(userAuthMongoProperties()));
    }

    @Bean
    public MongoTransactionManager sellerMongoTransactionManager() {
        return new MongoTransactionManager(userAuthMongoDatabaseFactory(userAuthMongoProperties()));
    }

    @Primary
    @Bean(name = "userAuthDBMongoTemplate")
    public MongoTemplate userAuthMongoTemplate() {
        MongoTemplate mongoTemplate = new MongoTemplate(userAuthMongoDatabaseFactory(userAuthMongoProperties()));
        mongoTemplate.setSessionSynchronization(SessionSynchronization.ON_ACTUAL_TRANSACTION);
        return mongoTemplate;
    }

    @Bean(name = "customerDBMongoTemplate")
    public MongoTemplate customerMongoTemplate() {
        MongoTemplate mongoTemplate = new MongoTemplate(customerMongoDatabaseFactory(customerMongoProperties()));
        mongoTemplate.setSessionSynchronization(SessionSynchronization.ON_ACTUAL_TRANSACTION);
        return mongoTemplate;
    }

    @Bean(name = "sellerDBMongoTemplate")
    public MongoTemplate sellerMongoTemplate() {
        MongoTemplate mongoTemplate = new MongoTemplate(sellerMongoDatabaseFactory(sellerMongoProperties()));
        mongoTemplate.setSessionSynchronization(SessionSynchronization.ON_ACTUAL_TRANSACTION);
        return mongoTemplate;
    }

    // @Bean
    // public MongoTemplate mongoTemplate() {
    //     DbRefResolver dbRefResolver = new DefaultDbRefResolver(mongoDbFactory());
    //     MappingMongoConverter mappingMongoConverter = new MappingMongoConverter(dbRefResolver, new MongoMappingContext());
    //     // Don't save _class to mongo
    //     mappingMongoConverter.setTypeMapper(new DefaultMongoTypeMapper(null));
    //     MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory(),mappingMongoConverter);
    //     mongoTemplate.setSessionSynchronization(SessionSynchronization.ON_ACTUAL_TRANSACTION);
    //     return mongoTemplate;
    // }

    // public MongoTemplate fetchMongoTemplate(int projectId) {
    //     DbRefResolver dbRefResolver = new DefaultDbRefResolver(mongoDbFactory());
    //     MappingMongoConverter mappingMongoConverter = new MappingMongoConverter(dbRefResolver, new MongoMappingContext());
    //     // Don't save _class to mongo
    //     mappingMongoConverter.setTypeMapper(new DefaultMongoTypeMapper(null));
    //     MongoDbFactory customizedDBFactory = new SimpleMongoDbFactory(mongoClient(), dbName+"_"+projectId);
    //     MongoTemplate mongoTemplate = new MongoTemplate(customizedDBFactory,mappingMongoConverter);
    //     MongoTransactionManager mongoTransactionManager = new MongoTransactionManager(customizedDBFactory);
    //     return mongoTemplate;
    // }
}
