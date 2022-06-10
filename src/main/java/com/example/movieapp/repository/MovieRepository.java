package com.example.movieapp.repository;

import com.example.movieapp.domain.Genre;
import com.example.movieapp.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer> {


    List<Movie> findAll();

    Movie findByMovieId(Integer movieId);

    List<Movie> findByTitle(String title);

    List<Movie> findByGenre(Genre genre);

    List<Movie> findByGenreOrderByRatingDesc(Genre genre);


    List<Movie> findAllByOrderByRatingDesc();
}
