package com.movieHam.movie.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.movieHam.movie.service.Movie;


public interface MovieRepository extends MongoRepository<Movie, Integer>, MovieCustomRepository{
}
