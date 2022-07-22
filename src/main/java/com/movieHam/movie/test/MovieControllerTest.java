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

import java.lang.reflect.InvocationTargetException;
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
        List<MovieVO> movieList = null;
        while(img == null || "".equals(img)){
            movieList = movieService.search("movieSeq", random + "");
            random = (int) ((Math.random() * (max - min)) + min);
            MovieVO movie = movieList.get(0);
            img = "".equals(movie.getPosters()) || movie.getPosters() == null ? movie.getStlls() : movie.getPosters();
            if(img.contains("|")){
                img = img.split("\\|")[0];
            }
        }

        MovieVO movie = movieList.get(0);
        System.out.println(movie);

        String result = "";
        result += "<!DOCTYPE html>";
        result += "<html lang='ko'>";
        result += "<head>";
        result += "<meta charset='utf-8'>";
        result += "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">";
        result += "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">";
        result += "<title>My test page</title>";
        result += "</head>";
        result += "<body>";
        result += "<body>";
        result += "<img src='"+ img +"' alt='My test image' style='width:300px'>";
        result += "<h1>" + movie.getTitle() + "</h1>";
        result += "<form action=\"/user/movie/insert\">";
        result += "<input type=\"text\" name=\"Docid\" value=\"" + movie.getDocid() + "\" hidden>";
        result += "<label for=\"seenYnY\">봤음<input type=\"radio\" id=\"seenYnY\" name=\"seenYn\" value=\"Y\"></label>";
        result += "<label for=\"seenYnN\">안봤음<input type=\"radio\" id=\"seenYnN\" name=\"seenYn\" value=\"N\"></label>";
        result += "<button>제출</button>";
        result += "</form>";
        result += "</body>";
        result += "</html>";


        return result;
    }





}
