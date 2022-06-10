package com.example.movieapp.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@Data
@NoArgsConstructor
public class Review {

    @Id
    private String reviewId;
    private String comment;

}
