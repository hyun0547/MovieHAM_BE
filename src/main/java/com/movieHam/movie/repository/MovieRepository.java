package com.movieHam.movie.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.movieHam.movie.service.Movie;

import java.util.List;
import java.util.Date;

public interface MovieRepository extends MongoRepository<Movie, Integer>, MovieCustomRepository{
    public List<Movie> findByReleaseDateBetween(Date from, Date to);
    public List<Movie> findByReleaseDateGreaterThan(Date from);
    public List<Movie> findByReleaseDateLessThan(Date to);
    public List<Movie> findByTitle(String title);
    public List<Movie> findByTitleContaining(String title);
    public List<Movie> findByIdIn(List<Integer> movieIdList);

}
