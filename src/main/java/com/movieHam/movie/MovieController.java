package com.movieHam.movie;

import com.util.api.ApiConnection;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
public class MovieController {

    @GetMapping(value="/movie/list", produces = "application/json; charset=UTF-8")
    public String list(){

        ApiConnection con = new ApiConnection();
        try {

            Map<String,Object> resultMap = con.kobisMoviList();
            String st = resultMap.toString();

            return st;
        }catch(Exception e){

            e.printStackTrace();
        }
        return null;
    }

    @GetMapping(value="/movie/search", produces = "application/json; charset=UTF-8")
    public String search(String title){

        ApiConnection con = new ApiConnection();
        try {

            Map<String,Object> resultMap = con.kmdbMovieSearch(title);
            String st = resultMap.toString();

            return st;
        }catch(Exception e){

            e.printStackTrace();
        }
        return null;
    }
}
