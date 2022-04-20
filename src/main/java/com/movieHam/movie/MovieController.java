package com.movieHam.movie;

import com.api.ApiConnection;
import com.movieHam.movie.vo.MovieVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MovieController {

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

    @GetMapping(value="/movie/{type}", produces = "application/json; charset=UTF-8")
    public String search(@PathVariable String title){

        ApiConnection con = new ApiConnection();
        try {

//            Map<String,Object> resultMap = con.kmdbMovieSearch();
//            String st = resultMap.toString();

//            return st;
        }catch(Exception e){

            e.printStackTrace();
        }
        return null;
    }

    @GetMapping(value="/movie/init", produces = "application/json; charset=UTF-8")
    public String init() throws Exception {

        MovieVO movieVO = new MovieVO();
        Map<String,String> paramMap = new HashMap<String,String>() {{
            put("releaseDts", "20220101");
        }};

        Map<String,Object> resultMap = ApiConnection.kmdbMovieSearch(paramMap);


        return resultMap.toString();
    }
}
