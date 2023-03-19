package com.movieHam.externalApi.movie.co;

import org.springframework.beans.factory.annotation.Value;

public class NAVER_API_DATA {

    public final static String HOST = "openapi.naver.com";
    public final static String SEARCH_MOVIE_PATH = "/v1/search/movie";

    public final static String TRANSLATION_PATH = "/v1/papago/n2mt";
    public final static String SEARCH_MOVIE_PATH_JSON = SEARCH_MOVIE_PATH + ".json";
    public final static String SEARCH_MOVIE_PATH_XML = SEARCH_MOVIE_PATH + ".xml";

    @Value("${movieham.api.naver.client-id}")
    public static String CLIENT_ID;
    @Value("${movieham.api.naver.client-secret}")
    public static String CLIENT_SECRET;

}
