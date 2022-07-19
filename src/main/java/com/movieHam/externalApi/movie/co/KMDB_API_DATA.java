package com.movieHam.externalApi.movie.co;

import org.springframework.beans.factory.annotation.Value;

public class KMDB_API_DATA {

    public final static String HOST = "api.koreafilm.or.kr";
    public final static String SEARCH_MOVIE_PATH_JSON = "/openapi-data2/wisenut/search_api/search_json2.jsp";
    public final static String SEARCH_MOVIE_PATH_XML = "/openapi-data2/wisenut/search_api/search_xml2.jsp";
    public static String COLLECTION = "kmdb_new2";

    @Value("${movieham.api.kmdb.client-secret}")
    public static String SERVICE_KEY;



}
