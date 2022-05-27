package com.movieHam.movie.externalApi;

import util.parser.http.ConnectionHandler;
import com.movieHam.movie.externalApi.co.KMDB_API_DATA;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.movieHam.movie.externalApi.co.NAVER_API_DATA;
import util.parser.map.MapHandler;
//import kr.or.kobis.kobisopenapi.consumer.rest.KobisOpenAPIRestService;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URIBuilder;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ApiConnection {

    public static Map<String, Object> naverMovieSearch(String title) throws Exception{

        String encodedTitle = URLEncoder.encode(title, "UTF-8");

        URI uri = new URIBuilder()
                .setScheme("https")
                .setHost(NAVER_API_DATA.HOST)
                .setPath(NAVER_API_DATA.SEARCH_MOVIE_PATH_JSON)
                .setParameter("query", encodedTitle)
                .setParameter("display", "1")
                .setParameter("start", "1")
                .build();

        HttpURLConnection con = (HttpURLConnection) uri.toURL().openConnection();
        con.setConnectTimeout(5000); //서버에 연결되는 Timeout 시간 설정
        con.setReadTimeout(5000); // InputStream 읽어 오는 Timeout 시간 설정
        con.setRequestMethod("GET");
        con.setRequestProperty("X-Naver-Client-Id", NAVER_API_DATA.CLIENT_ID);
        con.setRequestProperty("X-Naver-Client-Secret", NAVER_API_DATA.CLIENT_SECRET);
        con.setDoInput(true);

        String resultStr = ConnectionHandler.responseBodyToString(con);

        ObjectMapper mapper = new ObjectMapper();
        Map<String,Object> resultMap = mapper.readValue(resultStr, Map.class);

        return null;
    }

    public static Map<String, Object> kmdbMovieSearch(Map<String,String> paramMap) throws Exception {

        paramMap.put("collection", KMDB_API_DATA.COLLECTION);       // required parameter
        paramMap.put("ServiceKey", KMDB_API_DATA.SERVICE_KEY);      // required parameter

        // NameValuePair parameter 리스트로 변환
        List<NameValuePair> pairs = MapHandler.mapToNameValuePairList(paramMap);

        URI uri = new URIBuilder()
                .setScheme("http")
                .setHost(KMDB_API_DATA.HOST)
                .setPath(KMDB_API_DATA.SEARCH_MOVIE_PATH_JSON)
                .setParameters(pairs)
                .build();

        HttpURLConnection con = (HttpURLConnection) uri.toURL().openConnection();
        con.setConnectTimeout(5000); //서버에 연결되는 Timeout 시간 설정
        con.setReadTimeout(5000); // InputStream 읽어 오는 Timeout 시간 설정
        con.setRequestMethod("GET");
        con.setDoInput(true);

        String resultStr = ConnectionHandler.responseBodyToString(con);

        ObjectMapper mapper = new ObjectMapper();
        Map<String,Object> resultMap = mapper.readValue(resultStr, Map.class);

        return resultMap;
    }

    public ArrayList<Map<String,Object>> kmdbResultParse (Map<String,Object>resultMap){

        ArrayList<Map<String, Object>> data = (ArrayList<Map<String, Object>>) resultMap.get("Data");
        resultMap = data.get(0);

        return (ArrayList<Map<String, Object>>) resultMap.get("Result");

    }

//    public static Map<String, Object> kobisMovieList() throws Exception {
//
//        String key = "4cf7dc867e97031d7f33282407a7a1a0";
//
//        KobisOpenAPIRestService kobisApi = new KobisOpenAPIRestService(key);
//        Map<String,String> paramMap = new HashMap();
//        ObjectMapper mapper = new ObjectMapper();
//
//        String resultStr = kobisApi.getMovieList(true, paramMap);
//        Map<String,Object> resultMap = mapper.readValue(resultStr, Map.class);
//
//        return resultMap;
//    }


//    public HttpURLConnection getHttpUrlConnection(String protocol,String url,Map<String,String> param, Map<>){
//
//    }

}
