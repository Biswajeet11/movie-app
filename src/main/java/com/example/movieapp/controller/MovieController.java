package com.example.movieapp.controller;

import com.example.movieapp.domain.Genre;
import com.example.movieapp.domain.Movie;
import com.example.movieapp.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/movies")

public class MovieController {

    @Autowired
    private MovieService movieService;


    @GetMapping("/")
    public ResponseEntity<List<Movie>> getAllMovies() {
        return new ResponseEntity<>(movieService.getAllMovies(), HttpStatus.OK);
    }

    @GetMapping("/{movieId}")
    public ResponseEntity<Movie> getMovieById(@PathVariable("movieId") Integer movieId ){
        return new ResponseEntity<>(movieService.getByMovieId(movieId), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> addMovies(@Valid @RequestBody Movie movie) {

//        if(Objects.nonNull(movieService.getMovieByTitle(movie.getTitle()))){
//            return new ResponseEntity<>("Movie already Exist",HttpStatus.CONFLICT);
//        }
        System.out.println("movie..."+movie);

        movieService.addMovie(movie);
        return new ResponseEntity<>(movie,HttpStatus.CREATED);
    }

    @GetMapping("/title")
        public ResponseEntity <List<Movie>> getMoviesByTitle(@RequestParam() String movieTitle){

       List<Movie> movieList =  movieService.getMovieByTitle(movieTitle);
        if(movieList.size()>0){
            return new ResponseEntity<>(movieList,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
        }

    @GetMapping("/genre")
    public ResponseEntity <List<Movie>> getMovieByGenre(@RequestParam() Genre genre){

        List<Movie> movieList =  movieService.getMovieByGenre(genre);

        if(movieList.size()>0) {
            return new ResponseEntity<>(movieList,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

      }

      @GetMapping("/genre/sort")
      public ResponseEntity <List<Movie>> sortGenreByRating() {

          List<Movie> movieList =  movieService.sortMovieByRating();
            return new ResponseEntity<>(movieList,HttpStatus.OK);

      }

    }
