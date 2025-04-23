package com.example.dao;

import com.example.model.Movie;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;

public class MovieDAO {

    private final MongoCollection<Document> collection;

    public MovieDAO(MongoCollection<Document> collection) {
        this.collection = collection;
    }

    public void insert(Movie movie) {
        collection.insertOne(movie.toDocument());
    }

    public Movie findByTitle(String title) {
        Bson filter = Filters.eq("title", title);
        Document doc = collection.find(filter).first();
        if (doc != null) {
            return Movie.fromDocument(doc);
        } else {
            return null;
        }
    }

    public void updateRating(String title, double newRating) {
        Bson filter = Filters.eq("title", title);
        Bson update = new Document("$set", new Document("rating", newRating));
        collection.updateOne(filter, update);
    }

    public void delete(String title) {
        Bson filter = Filters.eq("title", title);
        collection.deleteOne(filter);
    }
}
