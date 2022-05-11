package com.movieHam.movie;

import com.api.ApiConnection;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
public class MovieController {


    @GetMapping(value="/movie/init", produces = "application/json; charset=UTF-8")
    public String init(){

        ApiConnection con = new ApiConnection();

        Map<String,String> paramMap = new HashMap<String,String>(){
            {
                put("listCount", "10");
                put("releaseDts", "2015-03-02");
            }
        };
        try {

            Map<String,Object> resultMap = con.kmdbMovieSearch(paramMap);
            ArrayList<Map<String, Object>> Data = (ArrayList<Map<String, Object>>) resultMap.get("Data");
            resultMap = Data.get(0);
            resultMap = (Map<String, Object>) resultMap.get("result");
            String st = resultMap.toString();

            return st;
        }catch(Exception e){

            e.printStackTrace();
        }
        return null;
    }

}
