package com.util.api;

import java.util.HashMap;
import java.util.Map;

public class KMDB_API_DATA {

    public final static String SEARCH_HOST = "api.koreafilm.or.kr";
    public final static String SEARCH_MOVIE_PATH = "/openapi-data2/wisenut/search_api/";

    public final static String SERVICE_KEY = "2CQ7DDD73D696E2FIQ0M";
    public final static String COLLECTION = "kmdb_new2";
    // XML search_xml2.jsp
    public static String getMovieSearchUriJson(){
        return SEARCH_HOST + SEARCH_MOVIE_PATH + "search_json2.jsp";
    }
}
