package com.movieHam.scheduler;

import com.movieHam.externalApi.movie.ApiConnection;
import com.movieHam.externalApi.movie.TmdbApiService;
import com.movieHam.movie.service.mapper.movieGenre.MovieGenre;
import com.movieHam.movie.service.mapper.movieGenre.MovieGenreService;
import com.movieHam.movie.service.mapper.moviePeople.MoviePeople;
import com.movieHam.movie.service.mapper.moviePeople.MoviePeopleService;
import com.movieHam.movie.service.movie.Movie;
import com.movieHam.movie.service.people.People;
import com.movieHam.movie.service.people.PeopleService;
import com.movieHam.movie.service.movie.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import util.parser.map.MapHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieScheduler {

    @Autowired
    MovieService movieService;

    @Autowired
    PeopleService peopleService;

    @Autowired
    MoviePeopleService moviePeopleService;

    @Autowired
    MovieGenreService movieGenreService;


    @Scheduled(cron = "0 0 13 * * *")
    private String getNewMovie(){

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

                totalPages = count == 1 ? (int) resultMap.get("total_pages") : totalPages;

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

}
