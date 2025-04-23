package com.example.model;

import org.bson.Document;

public class Movie {

    private String title;
    private int year;
    private String gender;
    private double rating;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Document toDocument() {
        return new Document("title", title)
                .append("year", year)
                .append("gender", gender)
                .append("rating", rating);
    }

    public static Movie fromDocument(Document doc) {
        Movie movie = new Movie();
        movie.setTitle(doc.getString("title"));
        movie.setYear(doc.getInteger("year"));
        movie.setGender(doc.getString("gender"));
        movie.setRating(doc.getDouble("rating"));

        return movie;
    }
}
