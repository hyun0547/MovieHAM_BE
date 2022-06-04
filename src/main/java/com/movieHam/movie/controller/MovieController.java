package com.movieHam.movie.controller;

import com.movieHam.movie.service.actor.ActorService;
import com.movieHam.movie.service.director.DirectorService;
import com.movieHam.movie.service.movie.MovieService;
import com.movieHam.movie.service.movie.MovieVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MovieController {

    @Autowired
    MovieService movieService;

    @Autowired
    ActorService actorService;

    @Autowired
    DirectorService directorService;

    @GetMapping(value="/movie/{searchType}", produces = "application/json; charset=UTF-8")
    public Map<String,Object> search(@PathVariable String searchType, String... keywords){

        if("actor".equals(searchType)){
//            actorService.search();
        }

        else if("director".equals(searchType)){
//            directorService.search();
        }

        Map<String,Object> result;
        try {

            List<MovieVO> resultList = movieService.search(searchType, keywords);

             result = new HashMap<>(){{
                put("resultList", resultList);
            }};


        }

        catch (NoSuchMethodException e){
            result = new HashMap<>(){{
                put("error", e.getMessage());
            }};
        }
        catch (InvocationTargetException e){
            result = new HashMap<>(){{
                put("error", e.toString());
            }};
        }
        catch (IllegalAccessException e){
            result = new HashMap<>(){{
                put("error", e.toString());
            }};
        }

        return result;

    }

}
