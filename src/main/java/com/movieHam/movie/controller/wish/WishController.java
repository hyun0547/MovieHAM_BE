package com.movieHam.movie.controller.wish;

import com.movieHam.movie.service.wish.WishService;
import com.movieHam.movie.service.movie.MovieService;
import com.movieHam.movie.service.movie.Movie;
import com.movieHam.movie.service.wish.WishVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
public class WishController {

    @Autowired
    MovieService movieService;

    @Autowired
    WishService wishService;

    @PostMapping(value="/wish/insert", produces = "application/json; charset=UTF-8")
    public void insert (WishVO wishVO) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        wishService.save(wishVO);
    }

    @PostMapping(value="/wish/modify")
    public String modify (Movie movieVO) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {

//        List<Movie> movieList = movieService.search("docid", movieVO.getDocid(), "");

        return "redirect:/movie/test";
    }

    @GetMapping(value="/wish/view/{userId}/{movieId}")
    public String view (WishVO wishVO) {
        try{
            return wishService.findById(wishVO).toString();
        }catch(Exception e){
            return "fail";
        }
    }

}
