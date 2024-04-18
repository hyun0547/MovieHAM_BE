package com.movieHam.wish.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.movieHam.wish.service.Wish;
import com.movieHam.wish.service.WishService;

import util.mapper.ResultSet;



@RestController
public class WishController {

    @Autowired
    private WishService wishService;

    @GetMapping("/wish/list")
    public ResultSet getWishList(
        @RequestParam Integer userId,
        Map<String, Object> categoryMap)
    {
        List<Wish> wishList = wishService.getWishList(userId);

        List<Integer> movieIdList = extractMovieIds(wishList);

        categoryMap.put("movieIdList", movieIdList);

        ResultSet result = requestMovieAPI(categoryMap);

        return result;
    }

    @PostMapping("/wish/insert")
    public void insertWish(
        @RequestBody Wish wish)
    {
        wishService.insertWish(wish);
    }

    public List<Integer> extractMovieIds(List<Wish> wishList){
        
        List<Integer> movieIdList = new ArrayList<>();
        for (Wish wish : wishList){
            movieIdList.add(wish.getMovieId());
        }

        return movieIdList;
    }

    public ResultSet requestMovieAPI(Map<String, Object> param){

        RestTemplate restTemplate = new RestTemplate();
                
        String url = "http://localhost:8080/movie/list";

        return restTemplate.postForObject(url, param, ResultSet.class);
    }
}
