package com.movieHam.movie.controller;


import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.annotation.Nullable;

import com.movieHam.movie.service.Movie;
import com.movieHam.movie.service.MovieSearch;
import com.movieHam.movie.service.MovieService;

import util.mapper.ResultSet;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping("/movie/list")
    public ResultSet<List<Movie>> getMovieList(
        @RequestParam(required = true) MovieSearch movieSearch) 
    {
        String searchType;
        if(movieSearch.getTitle() != null){
            searchType = "title";
        }else{
            searchType = "Date";
        }

        List<Movie> movieList = movieService.getMovieList(movieSearch, searchType);

        ResultSet<List<Movie>> result = new ResultSet<List<Movie>>("Success", "Test", movieList);
        
        return result;
    }

    @GetMapping("/movie/wish/list")
    public void getMovieListByWish() {

    }

}
