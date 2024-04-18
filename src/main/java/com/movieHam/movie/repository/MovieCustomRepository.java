package com.movieHam.movie.repository;

import java.util.List;

import com.movieHam.movie.service.Movie;
import com.movieHam.movie.service.MovieSearch;

public interface MovieCustomRepository {
    public List<Movie> findList(MovieSearch movieSearch);
}
