package com.example.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.testcontainers.containers.MongoDBContainer;

import java.util.Collections;

@TestConfiguration
@DataMongoTest(excludeAutoConfiguration = EmbeddedMongoAutoConfiguration.class)
public class TestMongoConfiguration {

    @Value("${mongo.database}")
    private String mongoDatabase;

    @Bean(name = "mongo-container")
    MongoDBContainer mongoContainerStartup() {
        MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:4.4.14-focal");
        mongoDBContainer.setPortBindings(Collections.singletonList("27018:27017"));
        mongoDBContainer.start();
        return mongoDBContainer;
    }

    @Bean
    @DependsOn("mongo-container")
    public MongoClient mongoClient() {
        return MongoClients.create("mongodb://localhost:27018");
    }

    @Bean
    public MongoTemplate mongoTemplate(final MongoClient mongoClient) {
        return new MongoTemplate(mongoClient, mongoDatabase);
    }
}
