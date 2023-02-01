package com.movieHam.movie.controller;

import com.movieHam.movie.service.wish.WishService;
import com.movieHam.movie.service.movie.MovieService;
import com.movieHam.movie.service.movie.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class WishController {

    @Autowired
    MovieService movieService;

    @Autowired
    WishService wishService;

    @RequestMapping(value="/movieHam/api/movie/wish/insert")
    public String insert (Movie movieVO) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {

        List<Movie> movieList = movieService.search("docid", movieVO.getDocid(), "");

        return "redirect:/movie/test";
    }

    @RequestMapping(value="/movieHam/api/movie/wish/modify")
    public String modify (Movie movieVO) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {

        List<Movie> movieList = movieService.search("docid", movieVO.getDocid(), "");

        return movieList.toString();
    }

}
