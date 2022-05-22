package com.movieHam.movie.web;

import com.movieHam.movie.api.ApiConnection;
import com.movieHam.movie.service.actor.ActorService;
import com.movieHam.movie.service.actor.ActorVO;
import com.movieHam.movie.service.director.DirectorService;
import com.movieHam.movie.service.director.DirectorVO;
import com.movieHam.movie.service.movie.MovieService;
import com.movieHam.movie.service.movie.MovieVO;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import util.parser.map.MapHandler;

import java.lang.reflect.Array;
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

    @GetMapping(value="/movie/init", produces = "application/json; charset=UTF-8")
    public String init(String startDate){

        ApiConnection con = new ApiConnection();

        Map<String,String> paramMap = new HashMap<String,String>(){
            {
                put("listCount", "10");
                put("releaseDts", startDate);
            }
        };

        try {

            Map<String,Object> resultMap = con.kmdbMovieSearch(paramMap);

            ArrayList<Map<String, Object>> movieInfoList = con.kmdbResultParse(resultMap);

            Map<String, Object> movieInfo = MapHandler.getMovieInfo(movieInfoList);

            ArrayList<MovieVO> movieList = (ArrayList<MovieVO>) movieInfo.get("movieList");
            ArrayList<ActorVO> actorList = (ArrayList<ActorVO>) movieInfo.get("actorList");
            ArrayList<DirectorVO> directorList = (ArrayList<DirectorVO>) movieInfo.get("directorList");

            return movieList.toString();

        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping(value="/movie/test", produces = "application/json; charset=UTF-8")
    public String test(){
        List<MovieVO> test = movieService.selectByTitle("사마에게");
        return "";
    }



}
