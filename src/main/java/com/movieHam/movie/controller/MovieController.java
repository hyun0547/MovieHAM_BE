package com.movieHam.movie.controller;

import com.movieHam.movie.service.actor.ActorService;
import com.movieHam.movie.service.actor.Actor;
import com.movieHam.movie.service.director.DirectorService;
import com.movieHam.movie.service.director.Director;
import com.movieHam.movie.service.mapper.movieActor.MovieActor;
import com.movieHam.movie.service.mapper.movieDirector.MovieDirector;
import com.movieHam.movie.service.movie.MovieService;
import com.movieHam.movie.service.movie.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import util.StringHandler;
import util.com.CommonUtil;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

@RestController
public class MovieController {

    @Autowired
    MovieService movieService;

    @Autowired
    ActorService actorService;

    @Autowired
    DirectorService directorService;

    @GetMapping(value="/movieHam/api/movie/search/{searchType}", produces = "application/json; charset=UTF-8")
    public Map<String,Object> search(@PathVariable String searchType, String keywords) {

        Class serviceClass = null;
        Method method = null;

        String firstUpperWord = StringHandler.firstLetterUpperCase(searchType);

        Map<String,Object> result;

        try {

            List<Movie> resultList = new ArrayList<>();

            if(CommonUtil.checkNullEmpty(searchType, "").contains("actor")){
                List<Actor> actorList = actorService.search(searchType, keywords);;

                List<MovieActor> movieActorList = new ArrayList<>();
                for(Actor actor : actorList){
                    movieActorList.addAll(actor.getMovieActor());
                }

                for(MovieActor movieActor : movieActorList){
                    resultList.add(movieActor.getMovie());
                }

            }else if(CommonUtil.checkNullEmpty(searchType, "").contains("director")){
                List<Director> directorList = directorService.search(searchType, keywords);;

                List<MovieDirector> movieDirectorList = new ArrayList<>();
                for(Director director : directorList){
                    movieDirectorList.addAll(director.getMovieDirector());
                }

                for(MovieDirector movieDirector : movieDirectorList){
                    resultList.add(movieDirector.getMovie());
                }
            }else{
                resultList = movieService.search(searchType, keywords);
            }

            Set<Movie> resultSet = new LinkedHashSet<>(resultList);
            result = new HashMap<>(){{
                put("resultList", resultSet);
            }};

        }catch (NoSuchMethodException e){
            result = new HashMap<>(){{
                put("error", e.getMessage());
            }};
        } catch (InvocationTargetException e) {
            result = new HashMap<>(){{
                put("error", e.getMessage());
            }};
        } catch (IllegalAccessException e) {
            result = new HashMap<>(){{
                put("error", e.getMessage());
            }};
        }

        return result;
    }



}
