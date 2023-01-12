package com.movieHam.movie.controller;

import com.movieHam.movie.service.actor.ActorService;
import com.movieHam.movie.service.actor.Actor;
import com.movieHam.movie.service.director.DirectorService;
import com.movieHam.movie.service.director.Director;
import com.movieHam.movie.service.mapper.movieActor.MovieActor;
import com.movieHam.movie.service.mapper.movieDirector.MovieDirector;
import com.movieHam.movie.service.movie.MovieDTO;
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

        Map<String,Object> result;

        if(CommonUtil.checkNullEmpty(keywords, "").equals("")){
            return new HashMap<>(){{
                put("error", "키워드 누락");
            }};
        }

        try {

            Set<MovieDTO> resultList = new LinkedHashSet<>();

            if(CommonUtil.checkNullEmpty(searchType, "").contains("actor")){
                List<Actor> actorList = actorService.search(searchType, keywords);
                for(Actor actor : actorList){
                    if(actor.getMovieActor() != null){
                        for(MovieActor movieActor : actor.getMovieActor()){
                            MovieDTO movieDTO = new MovieDTO(movieActor.getMovie());
                            resultList.add(movieDTO);
                        }
                    }
                }

            }else if(CommonUtil.checkNullEmpty(searchType, "").contains("director")){
                List<Director> directorList = directorService.search(searchType, keywords);
                for(Director director : directorList){
                    if(director.getMovieDirector() != null){
                        for(MovieDirector movieDirector : director.getMovieDirector()){
                            MovieDTO movieDTO = new MovieDTO(movieDirector.getMovie());
                            resultList.add(movieDTO);
                        }
                    }
                }

            }else{
                List<Movie> movieList = movieService.search(searchType, keywords);
                for(Movie movie : movieList){
                    MovieDTO movieDTO = new MovieDTO(movie);
                    resultList.add(movieDTO);
                }
            }

            Set<MovieDTO> resultSet = new LinkedHashSet<>(resultList);
            result = new HashMap<>(){{
                put("resultList", resultSet);
            }};

        }catch (NoSuchMethodException e){
            result = new HashMap<>(){{
                put("error", "검색형식 오류");
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
