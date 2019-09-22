package com.example.demo.pingvin;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

@Configuration
public class MongoDBConfig extends AbstractMongoConfiguration {

    @Override
    public MongoClient mongoClient() {
        return new MongoClient("127.0.0.1", 27017);
    }

    @Override
    protected String getDatabaseName() {
        return "Bouvetoeya";
    }
}
