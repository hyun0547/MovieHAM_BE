package com.movieHam.movie.service;

import java.util.List;

public interface MovieService {
    List<Movie> getMovieList(MovieSearch movieParam, String searchType);
    List<Movie> getMovieListByWish();
}
