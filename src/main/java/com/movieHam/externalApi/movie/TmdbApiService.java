package com.movieHam.externalApi.movie;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.movieHam.externalApi.movie.co.TMDB_API_DATA;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URIBuilder;
import util.parser.http.ConnectionHandler;
import util.parser.map.MapHandler;

import javax.net.ssl.HttpsURLConnection;
import java.net.URI;
import java.util.List;
import java.util.Map;

public class TmdbApiService {

    public static Map<String, Object> tmdbNowPlayingMovies(Map<String,String> paramMap) throws Exception {

        paramMap.put("api_key", TMDB_API_DATA.SERVICE_KEY);      // required parameter
        paramMap.put("language", "ko");      // required parameter

        // NameValuePair parameter 리스트로 변환
        List<NameValuePair> pairs = MapHandler.mapToNameValuePairList(paramMap);

        URI uri = new URIBuilder()
                .setScheme("https")
                .setHost(TMDB_API_DATA.HOST)
                .setPath(TMDB_API_DATA.GET_NOW_PLAYING_MOVIES_PATH)
                .setParameters(pairs)
                .build();

        HttpsURLConnection con = (HttpsURLConnection) uri.toURL().openConnection();
        con.setConnectTimeout(5000); //서버에 연결되는 Timeout 시간 설정
        con.setReadTimeout(5000); // InputStream 읽어 오는 Timeout 시간 설정
        con.setRequestMethod("GET");
        con.setDoInput(true);

        String resultStr = ConnectionHandler.responseBodyToString(con);

        ObjectMapper mapper = new ObjectMapper();
        Map<String,Object> resultMap = mapper.readValue(resultStr, Map.class);

        return resultMap;
    }

    public static Map<String, Object> tmdbPeoplesFromMovieId(Map<String,String> paramMap, Integer movieId) throws Exception {

        paramMap.put("api_key", TMDB_API_DATA.SERVICE_KEY);      // required parameter
        paramMap.put("language", "ko");      // required parameter

        // NameValuePair parameter 리스트로 변환
        List<NameValuePair> pairs = MapHandler.mapToNameValuePairList(paramMap);

        URI uri = new URIBuilder()
                .setScheme("https")
                .setHost(TMDB_API_DATA.HOST)
                .setPath("/3/movie/" + movieId + "/credits")
                .setParameters(pairs)
                .build();

        HttpsURLConnection con = (HttpsURLConnection) uri.toURL().openConnection();
        con.setConnectTimeout(5000); //서버에 연결되는 Timeout 시간 설정
        con.setReadTimeout(5000); // InputStream 읽어 오는 Timeout 시간 설정
        con.setRequestMethod("GET");
        con.setDoInput(true);

        String resultStr = ConnectionHandler.responseBodyToString(con);

        ObjectMapper mapper = new ObjectMapper();
        Map<String,Object> resultMap = mapper.readValue(resultStr, Map.class);

        return resultMap;
    }

    public static Map<String, Object> tmdbPeopleInfoFromPeopleId(Map<String,String> paramMap, Integer peopleId) throws Exception {

        paramMap.put("api_key", TMDB_API_DATA.SERVICE_KEY);      // required parameter

        // NameValuePair parameter 리스트로 변환
        List<NameValuePair> pairs = MapHandler.mapToNameValuePairList(paramMap);

        URI uri = new URIBuilder()
                .setScheme("https")
                .setHost(TMDB_API_DATA.HOST)
                .setPath("/3/person/" + peopleId)
                .setParameters(pairs)
                .build();

        HttpsURLConnection con = (HttpsURLConnection) uri.toURL().openConnection();
        con.setConnectTimeout(5000); //서버에 연결되는 Timeout 시간 설정
        con.setReadTimeout(5000); // InputStream 읽어 오는 Timeout 시간 설정
        con.setRequestMethod("GET");
        con.setDoInput(true);

        String resultStr = ConnectionHandler.responseBodyToString(con);

        ObjectMapper mapper = new ObjectMapper();
        Map<String,Object> resultMap = mapper.readValue(resultStr, Map.class);

        return resultMap;
    }

}
