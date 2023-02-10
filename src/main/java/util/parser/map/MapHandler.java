package util.parser.map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.movieHam.externalApi.movie.TmdbApiService;
import com.movieHam.movie.service.people.People;
import com.movieHam.movie.service.mapper.moviePeople.MoviePeople;
import com.movieHam.movie.service.movie.Movie;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import util.com.CommonUtil;

import java.sql.Date;
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
                setMovieData(movieBean, movie);

                Map<String,String> paramMap = new HashMap<String,String>(){
                    {
                        put("language", "ko");
                        put("page", "1");
                    }
                };
                Map<String,Object> peopleData = (Map<String, Object>) TmdbApiService.tmdbPeoplesFromMovieId(paramMap, movieBean.getMovieId());
                ArrayList<Map<String, Object>> peopleInfoList = (ArrayList<Map<String, Object>>) peopleData.get("cast");
                peopleInfoList.addAll((ArrayList<Map<String, Object>>) peopleData.get("crew"));

                if(peopleInfoList != null && peopleInfoList.size() > 0){
                    for(Map<String,Object> people : peopleInfoList){
                        People peopleBean = new People();
                        setPeopleData(peopleBean, people);

                        if(!"".equals(CommonUtil.checkNullEmpty(peopleBean.getPeopleId(), ""))){
                            peopleList.add(peopleBean);

                            MoviePeople moviePeople = new MoviePeople(movieBean, peopleBean);
                            moviePeople.setCharacter((String) people.get("character"));
                            moviePeople.setDepartment((String) people.get("department"));
                            moviePeople.setOrder((Integer) people.get("order"));
                            moviePeopleList.add(moviePeople);
                        }
                    }
                }

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

    public static void setMovieData(Movie movieBean, Map<String,Object> movie){
        if(movie.get("adult") != null) movieBean.setAdult(Boolean.parseBoolean(movie.get("adult").toString()));
        if(movie.get("backdrop_path") != null) movieBean.setBackdropPath(movie.get("backdrop_path").toString());
        if(movie.get("id") != null) movieBean.setMovieId(Integer.parseInt(movie.get("id").toString()));
        if(movie.get("original_language") != null) movieBean.setOriginalLanguage(movie.get("original_language").toString());
        if(movie.get("original_title") != null) movieBean.setOriginalTitle(movie.get("original_title").toString());
        if(movie.get("overview") != null) movieBean.setOverview(movie.get("overview").toString());
        if(movie.get("popularity") != null) movieBean.setPopularity(Double.parseDouble(movie.get("popularity").toString()));
        if(movie.get("poster_path") != null) movieBean.setPosterPath(movie.get("poster_path").toString());
        if(movie.get("release_date") != null) movieBean.setReleaseDate(Date.valueOf(movie.get("release_date").toString()));
        if(movie.get("title") != null) movieBean.setTitle(movie.get("title").toString());
        if(movie.get("vote_average") != null) movieBean.setVoteAverage(Double.parseDouble(movie.get("vote_average").toString()));
        if(movie.get("vote_count") != null) movieBean.setVoteCount(Integer.valueOf(movie.get("vote_count").toString()));
    }

    public static void setPeopleData(People peopleBean, Map<String,Object> people){
        if(!CommonUtil.checkNullEmpty(people.get("id"), "").equals("")) peopleBean.setPeopleId((Integer) people.get("id"));
        if(!CommonUtil.checkNullEmpty(people.get("adult"), "").equals("")) peopleBean.setAdult((Boolean) people.get("adult"));
        if(!CommonUtil.checkNullEmpty(people.get("gender"), "").equals("")) peopleBean.setGender((Integer) people.get("gender"));
        if(!CommonUtil.checkNullEmpty(people.get("known_for_department"), "").equals("")) peopleBean.setKnownForDepartment((String) people.get("known_for_department"));
        if(!CommonUtil.checkNullEmpty(people.get("name"), "").equals("")) peopleBean.setName((String) people.get("name"));
        if(!CommonUtil.checkNullEmpty(people.get("original_name"), "").equals("")) peopleBean.setOriginalName((String) people.get("original_name"));
        if(!CommonUtil.checkNullEmpty(people.get("popularity"), "").equals("")) peopleBean.setPopularity((Double) people.get("popularity"));
        if(!CommonUtil.checkNullEmpty(people.get("profile_path"), "").equals("")) peopleBean.setProfilePath((String) people.get("profile_path"));
        if(!CommonUtil.checkNullEmpty(people.get("job"), "").equals("")) peopleBean.setJob((String) people.get("job"));
    }
}
