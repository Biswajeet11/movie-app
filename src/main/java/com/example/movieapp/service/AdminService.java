package com.example.movieapp.service;

import com.example.movieapp.domain.Movie;
import com.example.movieapp.repository.MovieRepository;

public class AdminService {

    private MovieRepository movieRepository;

    public AdminService(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    public Movie addMovie(Movie movie){
        return movieRepository.save(movie);
    }
}
