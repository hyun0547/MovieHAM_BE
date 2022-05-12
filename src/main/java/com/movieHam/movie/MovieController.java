package com.movieHam.movie;

import com.api.ApiConnection;
import com.movieHam.actor.service.ActorService;
import com.movieHam.actor.vo.ActorVO;
import com.movieHam.movie.service.MovieService;
import com.movieHam.movie.vo.MovieVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
public class MovieController {

    @Autowired
    ActorService actorService;

    @Autowired
    MovieService movieService;

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

            System.out.println(actorService.getActor("test"));

            Map<String,Object> resultMap = con.kmdbMovieSearch(paramMap);
            ArrayList<Map<String, Object>> Data = (ArrayList<Map<String, Object>>) resultMap.get("Data");
            resultMap = Data.get(0);

            ArrayList<Map<String, Object>> MovieList = (ArrayList<Map<String, Object>>) resultMap.get("Result");
            ArrayList<MovieVO> movieBeanList= new ArrayList<>();
            for(Map<String, Object> movie : MovieList){

                MovieVO movieBean = new MovieVO();

                if(movie.get("DOCID") != null) movieBean.setDocid(movie.get("DOCID").toString());
                if(movie.get("movieId") != null) movieBean.setMovieId(movie.get("movieId").toString());
                if(movie.get("movieSeq") != null) movieBean.setMovieSeq(movie.get("movieSeq").toString());
                if(movie.get("actorId") != null) movieBean.setActorId(movie.get("actorid").toString());
                if(movie.get("awards1") != null) movieBean.setAwards1(movie.get("awards1").toString());
                if(movie.get("movieId") != null) movieBean.setMovieId(movie.get("movieId").toString());
                if(movie.get("movieSeq") != null) movieBean.setMovieSeq(movie.get("movieSeq").toString());
                if(movie.get("title") != null) movieBean.setTitle(movie.get("title").toString());
                if(movie.get("titleEng") != null) movieBean.setTitleEng(movie.get("titleEng").toString());
                if(movie.get("prodYear") != null) movieBean.setProdYear(movie.get("prodYear").toString());
                if(movie.get("nation") != null) movieBean.setNation(movie.get("nation").toString());
                if(movie.get("company") != null) movieBean.setCompany(movie.get("company").toString());
                if(movie.get("plotKor") != null) movieBean.setPlotKor(movie.get("plotKor").toString());
                if(movie.get("plotEng") != null) movieBean.setPlotEng(movie.get("plotEng").toString());
                if(movie.get("runtime") != null) movieBean.setRuntime(movie.get("runtime").toString());
                if(movie.get("rating") != null) movieBean.setRating(movie.get("rating").toString());
                if(movie.get("genre") != null) movieBean.setGenre(movie.get("genre").toString());
                if(movie.get("type") != null) movieBean.setType(movie.get("type").toString());
                if(movie.get("use") != null) movieBean.setUseClassification(movie.get("use").toString());
                if(movie.get("ratedYn") != null) movieBean.setRatedYn(movie.get("ratedYn").toString());
                if(movie.get("repRatDate") != null) movieBean.setRepRatDate(movie.get("repRatDate").toString());
                if(movie.get("repRlsDate") != null) movieBean.setRepRlsDate(movie.get("repRlsDate").toString());
                if(movie.get("keywords") != null) movieBean.setKeywords(movie.get("keywords").toString());
                if(movie.get("posters") != null) movieBean.setPosters(movie.get("posters").toString());
                if(movie.get("stlls") != null) movieBean.setStlls(movie.get("stlls").toString());
                if(movie.get("openThtr") != null) movieBean.setOpenThtr(movie.get("openThtr").toString());
                if(movie.get("awards1") != null) movieBean.setAwards1(movie.get("awards1").toString());
                if(movie.get("awards2") != null) movieBean.setAwards2(movie.get("awards2").toString());
                if(movie.get("regDate") != null) movieBean.setRegDate(movie.get("regDate").toString());
                if(movie.get("modDate") != null) movieBean.setModDate(movie.get("modDate").toString());
                movieBeanList.add(movieBean);
            }

            for(MovieVO movieBean : movieBeanList){
                movieService.saveMovie(movieBean);
            }

            return movieBeanList.toString();
        }catch(Exception e){

            e.printStackTrace();
        }
        return null;
    }

}
