package com.movieHam.movie.web;

import com.movieHam.movie.api.ApiConnection;
import com.movieHam.movie.service.actor.ActorService;
import com.movieHam.movie.service.actor.ActorVO;
import com.movieHam.movie.service.director.DirectorService;
import com.movieHam.movie.service.director.DirectorVO;
import com.movieHam.movie.service.movie.MovieService;
import com.movieHam.movie.service.movie.MovieVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
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
            ArrayList<Map<String, Object>> Data = (ArrayList<Map<String, Object>>) resultMap.get("Data");
            resultMap = Data.get(0);

            ArrayList<Map<String, Object>> MovieList = (ArrayList<Map<String, Object>>) resultMap.get("Result");
            ArrayList<MovieVO> movieBeanList= new ArrayList<>();

            for(Map<String, Object> movie : MovieList){

                MovieVO movieBean = new MovieVO();

                Map<String,Object> actorData = (Map<String, Object>) movie.get("actors");
                ArrayList<Map<String, Object>> actorList = (ArrayList<Map<String, Object>>) actorData.get("actor");

                if(actorList != null && actorList.size() > 0){

                    String actorIdListStr = "";
                    for(Map<String,Object> actor : actorList){

                        ActorVO actorBean = new ActorVO();

                        if(actor.get("actorNm") != null) actorBean.setActorNm(actor.get("actorNm").toString());
                        if(actor.get("actorEnNm") != null) actorBean.setActorEnNm(actor.get("actorEnNm").toString());
                        if(actor.get("actorId") != null) {
                            actorBean.setActorId(actor.get("actorId").toString());
                            actorIdListStr += "".equals(actor.get("actorId").toString()) ? "" : actor.get("actorId").toString() + "|";
                        }

                        actorService.insert(actorBean);
                    }

                    if(actorIdListStr.length() > 0) movieBean.setActorId(actorIdListStr);
                }

                Map<String,Object> directorData = (Map<String, Object>) movie.get("directors");
                ArrayList<Map<String, Object>> directorList = (ArrayList<Map<String, Object>>) directorData.get("director");

                if(directorList != null && directorList.size() > 0){

                    String directorIdListStr = "";
                    for(Map<String,Object> director : directorList){

                        DirectorVO directorBean = new DirectorVO();

                        if(director.get("directorNm") != null) directorBean.setDirectorNm(director.get("directorNm").toString());
                        if(director.get("directorEnNm") != null) directorBean.setDirectorEnNm(director.get("directorEnNm").toString());
                        if(director.get("directorId") != null) {
                            directorBean.setDirectorId(director.get("directorId").toString());
                            directorIdListStr += "".equals(director.get("directorId").toString()) ? "" : director.get("directorId").toString() + "|";
                        }

                        directorService.insert(directorBean);
                    }

                    if(directorIdListStr.length() > 0) movieBean.setDirectorId(directorIdListStr);
                }

                if(movie.get("DOCID") != null) movieBean.setDocid(movie.get("DOCID").toString());
                if(movie.get("movieId") != null) movieBean.setMovieId(movie.get("movieId").toString());
                if(movie.get("movieSeq") != null) movieBean.setMovieSeq(movie.get("movieSeq").toString());
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

            movieService.saveAll(movieBeanList);

            return movieBeanList.toString();
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
