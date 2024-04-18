package com.movieHam.movie.service;

import java.util.List;

import com.movieHam.common.SearchKeyword;

public interface MovieService {
    List<Movie> getMovieList(SearchKeyword movieParam);
    Movie getMovie(Integer id);
}
