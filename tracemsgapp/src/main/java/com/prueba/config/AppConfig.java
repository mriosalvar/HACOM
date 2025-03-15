package com.prueba.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "app")
public class AppConfig {
    private String mongodbDatabase;

    public String getMongodbDatabase() {
        return mongodbDatabase;
    }

    public void setMongodbDatabase(String mongodbDatabase) {
        this.mongodbDatabase = mongodbDatabase;
    }
}
