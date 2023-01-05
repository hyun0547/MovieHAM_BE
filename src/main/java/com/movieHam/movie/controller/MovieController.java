package com.movieHam.movie.controller;

import com.movieHam.movie.service.actor.ActorService;
import com.movieHam.movie.service.actor.ActorVO;
import com.movieHam.movie.service.director.DirectorService;
import com.movieHam.movie.service.director.DirectorVO;
import com.movieHam.movie.service.movie.MovieService;
import com.movieHam.movie.service.movie.MovieVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import util.com.CommonUtil;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
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

    @GetMapping(value="/movie/search/{searchType}", produces = "application/json; charset=UTF-8")
    public Map<String,Object> search(@PathVariable String searchType, String keywords){

        if("actor".equals(searchType)){
            keywords = CommonUtil.checkNullEmpty(getActorIdList(actorService.search(keywords)), "noActor");
            searchType = "actorId";
        }

        else if("director".equals(searchType)){
            keywords = CommonUtil.checkNullEmpty(getDirectorId(directorService.search(keywords)), "noDirector");
            searchType = "directorId";
        }

        Map<String,Object> result;
        try {
            List<MovieVO> resultList = movieService.search(searchType, keywords);

            result = new HashMap<>(){{
                put("resultList", resultList);
            }};
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e){
            result = new HashMap<>(){{
                put("error", e.getMessage());
            }};
        }

        return result;
    }

    private String getDirectorId(ArrayList<DirectorVO> directorList) {
        if(directorList == null){
            return "";
        }

        StringBuffer sb = new StringBuffer();

        for(DirectorVO director : directorList){
            sb.append(director.getDirectorId());
        }

        return sb.toString();
    }

    public String getActorIdList (List<ActorVO> actorList){
        if(actorList == null){
            return "";
        }

        StringBuffer sb = new StringBuffer();

        for(ActorVO actor : actorList){
            sb.append(actor.getActorId() + "|");
        }

        return sb.toString();
    }

}
