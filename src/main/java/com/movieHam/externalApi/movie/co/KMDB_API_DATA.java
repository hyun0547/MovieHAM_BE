package com.movieHam.externalApi.movie.co;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class KMDB_API_DATA {

    public final static String HOST = "api.koreafilm.or.kr";
    public final static String SEARCH_MOVIE_PATH_JSON = "/openapi-data2/wisenut/search_api/search_json2.jsp";
    public final static String SEARCH_MOVIE_PATH_XML = "/openapi-data2/wisenut/search_api/search_xml2.jsp";
    public static String COLLECTION = "kmdb_new2";
    public static String SERVICE_KEY;

    @Value("${movieham.api.kmdb.client-secret}")
    public String ServiceKey;

    @Value("${movieham.api.kmdb.client-secret}")
    public void setServiceKey(String serviceKey) {
        KMDB_API_DATA.SERVICE_KEY = serviceKey;
    }


}
