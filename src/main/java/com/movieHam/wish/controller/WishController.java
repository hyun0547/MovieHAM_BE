package com.movieHam.wish.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import util.mapper.ResultSet;



@RestController
public class WishController {

    @GetMapping("/wish/list")
    public ResultSet getWishList(
        ) 
    {
        RestTemplate restTemplate = new RestTemplate();
        String uri = "http://localhost:8080/movie/list?"+"title=범죄";

        ResultSet result = restTemplate.getForObject(uri, ResultSet.class);

        return result;
    }

    @GetMapping("/wish/insert")
    public void insertWish(
        )
    {
        
    }

}
