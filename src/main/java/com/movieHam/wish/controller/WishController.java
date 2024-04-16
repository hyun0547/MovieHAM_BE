package com.movieHam.wish.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import com.movieHam.movie.service.MovieSearch;


@RestController
public class WishController {

    @GetMapping("/wish/list")
    public void getMovieListByWish(
        @ModelAttribute MovieSearch movieSearch) 
    {
        
    }

}
