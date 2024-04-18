package com.movieHam.movie.service;

import java.util.List;

public interface MovieService {
    List<Movie> getMovieList(MovieSearch movieParam);
    Movie getMovie(Integer id);
}
