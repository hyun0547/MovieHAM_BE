package com.movieHam.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.movieHam.movie.service.Movie;
import com.movieHam.movie.service.MovieSearch;
import com.movieHam.movie.service.MovieService;

import util.mapper.ResultSet;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;



@RestController
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping("/movie/list")
    public ResultSet<List<Movie>> getMovieList(
        @ModelAttribute MovieSearch movieSearch) 
    {
        String searchType;
        if(movieSearch.getTitle() != null){
            searchType = "title";
        }else{
            searchType = "date";
        }

        List<Movie> movieList = movieService.getMovieList(movieSearch, searchType);

        ResultSet<List<Movie>> result = new ResultSet<List<Movie>>("Success", "Test", movieList);
        
        return result;
    }

    @GetMapping("/movie/wish/list")
    public void getMovieListByWish() {

    }

}
