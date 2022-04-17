package com.util.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.nashorn.internal.parser.JSONParser;
import kr.or.kobis.kobisopenapi.consumer.rest.KobisOpenAPIRestService;
import org.json.simple.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class ApiConnection {

    public Map<String, Object> naverMovieSearch(String title) throws Exception{

        String encodedTitle = URLEncoder.encode(title, "UTF-8");

        StringBuilder queryParam = new StringBuilder()
                .append("?query=" + encodedTitle)
                .append("&display=10")
                .append("&start=1");

        URL url = new URL("https://" + NAVER_API_DATA.getMovieSearchUriJson() + queryParam);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setConnectTimeout(5000); //서버에 연결되는 Timeout 시간 설정
        con.setReadTimeout(5000); // InputStream 읽어 오는 Timeout 시간 설정
        con.setRequestMethod("GET");
        con.setRequestProperty("X-Naver-Client-Id", NAVER_API_DATA.CLIENT_ID);
        con.setRequestProperty("X-Naver-Client-Secret", NAVER_API_DATA.CLIENT_SECRET);
        con.setDoInput(true);

        JSONObject commands = new JSONObject();

        int responseCode = con.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line = "";

            while ((line = br.readLine()) != null) {
                line.replaceAll("null", "");
                sb.append(line);
            }

            System.out.println(sb);
            ObjectMapper mapper = new ObjectMapper();
            Map<String,Object> resultMap = mapper.readValue(sb.toString(), Map.class);

            return resultMap;
        } else {
            System.out.println(responseCode + " Error!");
        }

        return null;
    }

    public Map<String, String> kobisMoviList() throws Exception {

        String key = "4cf7dc867e97031d7f33282407a7a1a0";

        KobisOpenAPIRestService kobisApi = new KobisOpenAPIRestService(key);
        Map<String,String> paramMap = new HashMap();
        ObjectMapper mapper = new ObjectMapper();

        String resultStr = kobisApi.getMovieList(true, paramMap);
        Map<String,String> resultMap = mapper.readValue(resultStr, Map.class);

        return resultMap;
    }
}
