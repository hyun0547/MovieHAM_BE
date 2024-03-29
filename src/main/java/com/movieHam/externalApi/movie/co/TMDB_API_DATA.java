package com.movieHam.externalApi.movie.co;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class TMDB_API_DATA {
    public final static String HOST = "api.themoviedb.org";
    public final static String GET_NOW_PLAYING_MOVIES_PATH = "/3/movie/now_playing";
    public final static String GET_MOVIE_PEOPLE_PATH = "/3/movie/76600/credits";
    public static String SERVICE_KEY;

    @Value("${movieham.api.tmdb.client-secret}")
    public String ServiceKey;

    @Value("${movieham.api.tmdb.client-secret}")
    public void setServiceKey(String serviceKey) {
        TMDB_API_DATA.SERVICE_KEY = serviceKey;
    }
}
