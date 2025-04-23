package com.example.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoConfig {
    
    private static final String URI = "mongodb+srv://melomoraes:melomoraes@mongoatvdd.wbpfc.mongodb.net/sample_mflix?retryWrites=true&w=majority";
    
    @Bean
    public MongoClient mongoClient() {
        return MongoClients.create(URI);
    }
}