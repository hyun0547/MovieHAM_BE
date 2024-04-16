package com.movieHam.movie.service;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Date;

public interface MovieRepository extends MongoRepository<Movie, Integer>{
    public List<Movie> findByReleaseDateBetween(Date from, Date to);
    public List<Movie> findByReleaseDateGreaterThan(Date from);
    public List<Movie> findByReleaseDateLessThan(Date to);
    public List<Movie> findByTitle(String title);
    public List<Movie> findByTitleContaining(String title);
}
