package com.example;

import com.example.config.MongoConfig;
import com.example.controller.MovieController;
import com.example.dao.MovieDAO;
import com.example.service.MovieService;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;

public class Main {

    public static void main(String[] args) {
        MongoConfig mongoConfig = new MongoConfig();
        try (MongoClient mongoClient = mongoConfig.mongoClient()) {
            MongoDatabase database = mongoClient.getDatabase("sample_mflix");
            MovieDAO movieDAO = new MovieDAO(database.getCollection("movies"));
            MovieService movieService = new MovieService(movieDAO);
            MovieController controller = new MovieController(movieService);
            controller.runDemo();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
