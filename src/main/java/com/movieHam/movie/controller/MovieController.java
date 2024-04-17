package com.movieHam.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

import com.movieHam.movie.service.Movie;
import com.movieHam.movie.service.MovieSearch;
import com.movieHam.movie.service.MovieService;

import util.mapper.ResultSet;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping("/movie/list")
    public ResultSet getMovieList(
        @ModelAttribute MovieSearch movieSearch) 
    {
        String searchType;
        if(movieSearch.getTitle() != null){
            searchType = "title";
        }else{
            searchType = "date";
        }

        List<Movie> movieList = movieService.getMovieList(movieSearch, searchType);

        Map<String, Object> data = Map.of("list", movieList);

        ResultSet result = new ResultSet("Success", "Test", data);
        
        return result;
    }

    @GetMapping("/movie/{id}")
    public ResultSet getMovie(
        @PathVariable("id") Integer id)
    {
        Map<String, Object> data = Map.of("data", movieService.getMovie(id));
        return new ResultSet("Success", "Test", data);
    }

}
