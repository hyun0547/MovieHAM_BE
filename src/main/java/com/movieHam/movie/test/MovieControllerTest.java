package com.movieHam.movie.test;

import com.movieHam.externalApi.movie.TmdbApiService;
import com.movieHam.movie.service.mapper.movieGenre.MovieGenre;
import com.movieHam.movie.service.mapper.movieGenre.MovieGenreService;
import com.movieHam.movie.service.people.PeopleService;
import com.movieHam.movie.service.people.People;
import com.movieHam.movie.service.mapper.moviePeople.MoviePeople;
import com.movieHam.movie.service.mapper.moviePeople.MoviePeopleService;
import com.movieHam.movie.service.movie.MovieService;
import com.movieHam.movie.service.movie.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import util.parser.map.MapHandler;

import java.util.*;

@Controller
public class MovieControllerTest {

    @Autowired
    MovieService movieService;

    @Autowired
    PeopleService peopleService;

    @Autowired
    MoviePeopleService moviePeopleService;

    @Autowired
    MovieGenreService movieGenreService;

    @GetMapping(value="/movie/init", produces = "application/json; charset=UTF-8")
    public String init(String startDate){

        TmdbApiService tmdbApi = new TmdbApiService();
        int count = 1;
        int totalPages = 1;

        while(count <= totalPages){
            int finalCount = count;
            Map<String,String> paramMap = new HashMap<String,String>(){
                {
                    put("language", "ko");
                    put("page", String.valueOf(finalCount));
                }
            };

            try {

                Map<String,Object> resultMap = tmdbApi.tmdbNowPlayingMovies(paramMap);

//                totalPages = totalPages == 2 ? (int) resultMap.get("total_pages") : totalPages;

                Map<String, Object> movieInfo = MapHandler.getMovieInfo((List<Map<String, Object>>) resultMap.get("results"));

                movieService.saveAll((ArrayList<Movie>) movieInfo.get("movieList"));
                peopleService.saveAll((ArrayList<People>) movieInfo.get("peopleList"));
                moviePeopleService.saveAll((ArrayList<MoviePeople>) movieInfo.get("moviePeopleList"));
                movieGenreService.saveAll((ArrayList<MovieGenre>) movieInfo.get("movieGenreList"));

            }catch(Exception e){
                e.printStackTrace();
            }finally {
                count++;
            }
        }

        return null;
    }

//    , produces = "text/html; charset=UTF-8"
    @RequestMapping(value="/movie/test")
    @ResponseBody
    public String test() throws Exception {

        return null;
    }
}
