package util.parser.map;

import com.movieHam.movie.service.people.People;
import com.movieHam.movie.service.mapper.moviePeople.MoviePeople;
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

        ArrayList<Movie> movieList = new ArrayList<>();
        ArrayList<People> peopleList = new ArrayList<>();
        ArrayList<MoviePeople> moviePeopleList = new ArrayList<>();

        try {
            for(Map<String, Object> movie : movieInfoList){

                Movie movieBean = new Movie();

                setMovieDate(movieBean, movie);

                Map<String,Object> peopleData = (Map<String, Object>) movie.get("peoples");
                ArrayList<Map<String, Object>> peopleInfoList = (ArrayList<Map<String, Object>>) peopleData.get("people");

                if(peopleInfoList != null && peopleInfoList.size() > 0){

                    for(Map<String,Object> people : peopleInfoList){

                        People peopleBean = new People();

                        if(!CommonUtil.checkNullEmpty(people.get("peopleNm"), "").equals("")) peopleBean.setPeopleNm(people.get("peopleNm").toString());
                        if(!CommonUtil.checkNullEmpty(people.get("peopleEnNm"), "").equals("")) peopleBean.setPeopleEnNm(people.get("peopleEnNm").toString());
                        if(!CommonUtil.checkNullEmpty(people.get("peopleId"), "").equals("")) {
                            peopleBean.setPeopleId(people.get("peopleId").toString());
                        }

                        if(peopleBean.getPeopleId() != null){
                            peopleList.add(peopleBean);

                            MoviePeople moviePeople = new MoviePeople(movieBean, peopleBean);
                            moviePeopleList.add(moviePeople);
                        }
                    }
                }

                Map<String,Object> directorData = (Map<String, Object>) movie.get("directors");
                ArrayList<Map<String, Object>> directorInfoList = (ArrayList<Map<String, Object>>) directorData.get("director");


                movieList.add(movieBean);
            }
            Map<String, Object> movieInfo = new HashMap<>(){{

                put("movieList", movieList);
                put("peopleList", peopleList);
                put("moviePeopleList", moviePeopleList);

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
        if(!"".equals(CommonUtil.checkNullEmpty(movie.get("posters"),""))) movieBean.setPosters(movie.get("posters").toString());
        if(movie.get("stlls") != null) movieBean.setStlls(movie.get("stlls").toString());
        if(movie.get("openThtr") != null) movieBean.setOpenThtr(movie.get("openThtr").toString());
        if(movie.get("Awards1") != null) movieBean.setAwards1(movie.get("Awards1").toString());
        if(movie.get("Awards1") != null) movieBean.setAwards2(movie.get("Awards1").toString());
        if(movie.get("regDate") != null) movieBean.setRegDate(movie.get("regDate").toString());
        if(movie.get("modDate") != null) movieBean.setModDate(movie.get("modDate").toString());
    }
}
