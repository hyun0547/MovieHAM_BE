package com.movieHam.movie.controller;

import com.movieHam.movie.service.actor.ActorService;
import com.movieHam.movie.service.director.DirectorService;
import com.movieHam.movie.service.movie.MovieRepository;
import com.movieHam.movie.service.movie.MovieService;
import com.movieHam.movie.service.movie.MovieVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
public class MovieControllerApi {

    @Autowired
    MovieService movieService;

    @Autowired
    ActorService actorService;

    @Autowired
    DirectorService directorService;

    @GetMapping(value="/movie/{searchType}", produces = "application/json; charset=UTF-8")
    public String search(@PathVariable String searchType, String... keywords){

        if("actor".equals(searchType)){
//            actorService.search();
        }
        else if("director".equals(searchType)){
//            directorService.search();
        }

        try {
            List<MovieVO> resultList = movieService.search(searchType, keywords);
            return resultList.toString();
        }
        catch (NoSuchMethodException e){
            return e.toString();
        }
        catch (InvocationTargetException e){
            return e.toString();
        }
        catch (IllegalAccessException e){
            return e.toString();
        }

    }

}
