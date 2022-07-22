package com.movieHam.movie.controller;

import com.movieHam.movie.service.wish.WishService;
import com.movieHam.movie.service.movie.MovieService;
import com.movieHam.movie.service.movie.MovieVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class WishController {

    @Autowired
    MovieService movieService;

    @Autowired
    WishService wishService;

    @RequestMapping(value="/movie/wish/insert")
    public String insertMovie (MovieVO movieVO) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {

        List<MovieVO> movieList = movieService.search("docid", movieVO.getDocid());

        return "redirect:/movie/test";
    }

}
