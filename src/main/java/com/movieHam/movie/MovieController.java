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
    public String getMovieList(){

        ApiConnection con = new ApiConnection();
        try {

            Map<String,String> resultMap = con.kobisMoviList();
            String st = resultMap.toString();
            return st;
        }catch(Exception e){

            e.printStackTrace();
        }
        return null;
    }

    @GetMapping(value="/movie/search", produces = "application/json; charset=UTF-8")
    public String searchMovie(String title){

        ApiConnection con = new ApiConnection();
        try {

//            Map<String,Object> resultMap = con.naverMovieSearchConnection(title);
//            String st = resultMap.toString();
            return con.naverMovieSearch(title).toString();
        }catch(Exception e){

            e.printStackTrace();
        }
        return null;
    }
}
