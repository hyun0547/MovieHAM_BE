package com.movieHam.movie.test;

import com.movieHam.externalApi.movie.ApiConnection;
import com.movieHam.movie.service.actor.ActorService;
import com.movieHam.movie.service.actor.ActorVO;
import com.movieHam.movie.service.director.DirectorService;
import com.movieHam.movie.service.director.DirectorVO;
import com.movieHam.movie.service.movie.MovieService;
import com.movieHam.movie.service.movie.MovieVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import util.parser.map.MapHandler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class MovieControllerTest {

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
                put("listCount", "100");
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

            movieService.insertAll(movieList);
            actorService.insertAll(actorList);
            directorService.insertAll(directorList);

            return movieList.toString();

        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

//    , produces = "text/html; charset=UTF-8"
    @RequestMapping(value="/movie/test")
    @ResponseBody
    public String test() throws Exception {

//        String test2 = "";
//        String test3 = "";
//        ApiConnection con = new ApiConnection();
//        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
//        Calendar cal = Calendar.getInstance();
//
//        ArrayList<Map<String, Object>> movieInfoList = new ArrayList<>();
//        for(int year = 55000; year > 54000; year--){
//
//            Map<String, String> paramMap = new HashMap<>();
//            paramMap.put("movieSeq", year +"");
//
//            Map<String,Object> resultMap = con.kmdbMovieSearch(paramMap);
//
//            List<Map<String, Object>> list = con.kmdbResultParse(resultMap);
//            if(list != null){
//                movieInfoList.addAll(list);
//            }
//        }
//
//        Map<String, Object> movieInfo = MapHandler.getMovieInfo(movieInfoList);
//
//        if(movieInfo != null){
//            ArrayList<MovieVO> movieList = (ArrayList<MovieVO>) movieInfo.get("movieList");
//            ArrayList<ActorVO> actorList = (ArrayList<ActorVO>) movieInfo.get("actorList");
//            ArrayList<DirectorVO> directorList = (ArrayList<DirectorVO>) movieInfo.get("directorList");
//
//            movieService.insertAll(movieList);
//            actorService.insertAll(actorList);
//            directorService.insertAll(directorList);
//        }

        int min = 55000;
        int max = 55980;
        int random = (int) ((Math.random() * (max - min)) + min);
        String img = "";
        while(img == null || "".equals(img)){
            List<MovieVO> movieList = movieService.search("movieSeq", random + "");
            random = (int) ((Math.random() * (max - min)) + min);
            MovieVO movie = movieList.get(0);
            img = "".equals(movie.getPosters()) || movie.getPosters() == null ? movie.getStlls() : movie.getPosters();
            if(img.contains("|")){
                img = img.split("\\|")[0];
            }
        }

        return "<img src='"+ img + "' style='width:700px'>";
    }



}
