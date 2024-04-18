package com.movieHam.movie.repository;

import java.util.List;

import com.movieHam.common.SearchKeyword;
import com.movieHam.movie.service.Movie;

public interface MovieCustomRepository {
    public List<Movie> findList(SearchKeyword movieSearch);
}
