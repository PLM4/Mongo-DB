package com.example.controller;

import com.example.model.Movie;
import com.example.service.MovieService;

public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    public void runDemo() {
        com.example.model.Movie movie = new Movie();
        movie.setTitle("Novo filme");
        movie.setYear(2025);
        movie.setGender("Ficção");
        movie.setRating(7.7);

        movieService.addNewMovie(movie);

        com.example.model.Movie found = movieService.getMovieByTitle("Novo filme");
        if (found != null) {
            System.out.println("Found" + found.getTitle());
        }

        movieService.updateMovie("Novo filme", 7.5);

        movieService.removeMovie("Novo filme");
    }
}
