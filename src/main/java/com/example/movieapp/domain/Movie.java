package com.example.movieapp.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Data
@NoArgsConstructor
@Table(name="movie_table")
public class Movie {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer movieId;

    private String title;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    @Min(value = 0, message ="Minimum value should be 0")
    @Max(value = 5, message = "Maximum value should be 5")
    private int rating;


}
