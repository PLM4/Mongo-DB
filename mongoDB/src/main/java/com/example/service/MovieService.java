package com.example.service;

import com.example.dao.MovieDAO;
import com.example.model.Movie;

public class MovieService {
    private final MovieDAO movieDAO;

    public MovieService(MovieDAO movieDAO){
        this.movieDAO = movieDAO;
    }

    public void addNewMovie(Movie movie){
        movieDAO.insert(movie);
    }

    public Movie getMovieByTitle(String title){
        return movieDAO.findByTitle(title);
    }

    public void updateMovie(String title, double rating){
        movieDAO.updateRating(title, rating);
    }

    public void removeMovie(String title){
        movieDAO.delete(title);
    }
}
