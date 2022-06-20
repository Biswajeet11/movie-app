package com.example.movieapp.service;

import com.example.movieapp.domain.Genre;
import com.example.movieapp.domain.Movie;
import com.example.movieapp.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;


    public void addMovie(Movie movie){
        movieRepository.save(movie);
    }


    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }


    public List<Movie> getMovieByTitle(String title) {
      return  movieRepository.findByTitle(title);
    }

    public List<Movie> getMovieByGenre(Genre genre){
        return movieRepository.findByGenre(genre);
    }

    public List<Movie>  sortMovieByRating(){
        return  movieRepository.findAllByOrderByRatingDesc();
    }

    public Movie getByMovieId(Integer movieId) {
        return movieRepository.findByMovieId(movieId);
    }


}
