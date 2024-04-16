package com.movieHam.movie.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService{

    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> getMovieList(MovieSearch movieParam, String searchType) {
        
        List<Movie> movieList = movieRepository.findByReleaseDateBetween(movieParam.getFromDate(), movieParam.getToDate());
        return movieList;
    }

    @Override
    public List<Movie> getMovieListByWish() {
        List<Movie> movieList = new ArrayList<Movie>();
        movieList.add(new Movie());
        return movieList;
    }



}
