package com.movieHam.scheduler;

import com.movieHam.externalApi.movie.ApiConnection;
import com.movieHam.movie.service.actor.ActorService;
import com.movieHam.movie.service.director.DirectorService;
import com.movieHam.movie.service.movie.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.HashMap;
import java.util.Map;

public class MovieScheduler {

    @Autowired
    MovieService movieService;

    @Autowired
    ActorService actorService;

    @Autowired
    DirectorService directorService;

//    @Scheduled(cron = "0 0 0/1 * * *")
    @Scheduled(fixedDelay=10000)
    private String getNewMovie(){


        Map<String, String> paramMap = new HashMap<>(){{
            put("listCount", "100");
            put("createDts", "");
            put("createDte", "2022-07-16");
        }};
//        ApiConnection.kmdbMovieSearch();
        return "";
    }

}
