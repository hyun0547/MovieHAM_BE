package com.movieHam.movie;

import com.api.ApiConnection;
import com.movieHam.movie.service.ActorService;
import com.movieHam.actor.vo.MovieVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MovieController {

    @Autowired
    ActorService actorService;

    @GetMapping(value="/movie/list", produces = "application/json; charset=UTF-8")
    public String list(){

        ApiConnection con = new ApiConnection();
        try {

            Map<String,Object> resultMap = con.kobisMovieList();
            String st = resultMap.toString();

            return st;
        }catch(Exception e){

            e.printStackTrace();
        }
        return null;
    }

    @GetMapping(value="/movie/test", produces = "application/json; charset=UTF-8")
    public String search(@PathVariable(required = false) String type){

        return null;
    }

    @GetMapping(value="/movie/search/{keyword}", produces = "application/json; charset=UTF-8")
    public String init(@PathVariable(name = "keyword") String keyword, String param) throws Exception {

        MovieVO movieVO = new MovieVO();
        Map<String,String> paramMap = new HashMap<String,String>() {{
            put(keyword, param);
        }};

        Map<String,Object> resultMap = ApiConnection.kmdbMovieSearch(paramMap);

        return resultMap.toString();
    }
}
