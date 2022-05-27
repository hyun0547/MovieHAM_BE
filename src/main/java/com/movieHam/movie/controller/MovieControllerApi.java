package com.movieHam.movie.controller;

import com.movieHam.movie.service.movie.MovieRepository;
import com.movieHam.movie.service.movie.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieControllerApi {

    @Autowired
    MovieService movieService;

    @GetMapping(value="/movie/{type}", produces = "application/json; charset=UTF-8")
    public String search(@PathVariable String type, String keyword){

        try {
            movieService.search(type, keyword);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }

}
