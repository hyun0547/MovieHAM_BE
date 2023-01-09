package util.parser.map;

import com.movieHam.movie.service.actor.ActorVO;
import com.movieHam.movie.service.director.DirectorVO;
import com.movieHam.movie.service.mapper.movieActor.MovieActor;
import com.movieHam.movie.service.mapper.movieDirector.MovieDirector;
import com.movieHam.movie.service.movie.Movie;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import util.com.CommonUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapHandler {

    public static List<NameValuePair> mapToNameValuePairList (Map<String,String> paramMap){

        List<NameValuePair> pairs = new ArrayList<>();

        for (Map.Entry<String, String> entry : paramMap.entrySet()) {
            pairs.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }

        return pairs;
    }

    public static Map<String,Object> getMovieInfo(List<Map<String,Object>> movieInfoList){

        ArrayList<Movie> movieVoList = new ArrayList<>();
        ArrayList<ActorVO> actorVoList = new ArrayList<>();
        ArrayList<DirectorVO> directorVoList = new ArrayList<>();
        ArrayList<MovieActor> movieActorList = new ArrayList<>();
        ArrayList<MovieDirector> movieDirectorList = new ArrayList<>();

        try {
            for(Map<String, Object> movie : movieInfoList){

                Movie movieBean = new Movie();

                setMovieDate(movieBean, movie);

                Map<String,Object> actorData = (Map<String, Object>) movie.get("actors");
                ArrayList<Map<String, Object>> actorList = (ArrayList<Map<String, Object>>) actorData.get("actor");

                if(actorList != null && actorList.size() > 0){

                    for(Map<String,Object> actor : actorList){

                        ActorVO actorBean = new ActorVO();

                        if(!CommonUtil.checkNullEmpty(actor.get("actorNm"), "").equals("")) actorBean.setActorNm(actor.get("actorNm").toString());
                        if(!CommonUtil.checkNullEmpty(actor.get("actorEnNm"), "").equals("")) actorBean.setActorEnNm(actor.get("actorEnNm").toString());
                        if(!CommonUtil.checkNullEmpty(actor.get("actorId"), "").equals("")) {
                            actorBean.setActorId(actor.get("actorId").toString());
                        }

                        if(actorBean.getActorId() != null){
                            actorVoList.add(actorBean);

                            MovieActor movieActor = new MovieActor();
                            movieActor.setActor(actorBean);
                            movieActor.setMovie(movieBean);
                            movieActorList.add(movieActor);
                        }
                    }
                }

                Map<String,Object> directorData = (Map<String, Object>) movie.get("directors");
                ArrayList<Map<String, Object>> directorList = (ArrayList<Map<String, Object>>) directorData.get("director");

                if(directorList != null && directorList.size() > 0){

                    for(Map<String,Object> director : directorList){

                        DirectorVO directorBean = new DirectorVO();

                        if(!CommonUtil.checkNullEmpty(director.get("directorNm"), "").equals("")) directorBean.setDirectorNm(director.get("directorNm").toString());
                        if(!CommonUtil.checkNullEmpty(director.get("directorEnNm"), "").equals("")) directorBean.setDirectorEnNm(director.get("directorEnNm").toString());
                        if(!CommonUtil.checkNullEmpty(director.get("directorId"), "").equals("")) {
                            directorBean.setDirectorId(director.get("directorId").toString());
                        }

                        if(directorBean.getDirectorId() != null){
                            directorVoList.add(directorBean);

                            MovieDirector movieDirector = new MovieDirector();

                            movieDirector.setDirector(directorBean);
                            movieDirector.setMovie(movieBean);
                            movieDirectorList.add(movieDirector);
                        }
                    }
                }

                movieVoList.add(movieBean);
            }
            Map<String, Object> movieInfo = new HashMap<>(){{

                put("movieList", movieVoList);
                put("actorList", actorVoList);
                put("directorList", directorVoList);
                put("movieActorList", movieActorList);
                put("movieDirectorList", movieDirectorList);

            }};
            return movieInfo;
        }catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }

    public static void setMovieDate(Movie movieBean, Map<String,Object> movie){
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
        if(movie.get("plots") != null){
            Map<String,Object> plots = (Map<String, Object>) movie.get("plots");
            ArrayList<Map<String,Object>> plotList = (ArrayList<Map<String, Object>>) plots.get("plot");
            if(plotList != null){
                for(Map<String,Object> plot : plotList){
                    if("한국어".equals(plot.get("plotLang"))){
                        movieBean.setPlotKor(plot.get("plotText").toString());
                    }else if(plot.get("plotLang") != null && !"".equals(plot.get("plotLang"))){
                        movieBean.setPlotEng(plot.get("plotText").toString());
                    }
                }
            }

        }
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
        if(movie.get("Awards1") != null) movieBean.setAwards1(movie.get("Awards1").toString());
        if(movie.get("Awards1") != null) movieBean.setAwards2(movie.get("Awards1").toString());
        if(movie.get("regDate") != null) movieBean.setRegDate(movie.get("regDate").toString());
        if(movie.get("modDate") != null) movieBean.setModDate(movie.get("modDate").toString());
    }
}
