package com.util.api;

public class NAVER_API_DATA {

    public final static String SEARCH_HOST = "openapi.naver.com";
    public final static String SEARCH_MOVIE_PATH = "/v1/search/movie";

    public final static String CLIENT_ID = "sUqhlNckQA4xu0S9J5pz";
    public final static String CLIENT_SECRET = "6srFNl6BQg";

    public static String getMovieSearchUriJson(){
        return SEARCH_HOST + SEARCH_MOVIE_PATH + ".json";
    }
}
