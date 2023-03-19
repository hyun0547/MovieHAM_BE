package com.movieHam.externalApi.translation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.movieHam.externalApi.movie.co.NAVER_API_DATA;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import util.parser.http.ConnectionHandler;

import java.io.IOException;
import java.net.*;
import java.util.Map;

public class Papago {
    public static String translate(String target, String from, String to) throws IOException, URISyntaxException {

        HttpClient httpclient = HttpClients.createDefault();

        URIBuilder builder = new URIBuilder("https://openapi.naver.com/v1/papago/n2mt");

        builder.setParameter("source", from)
                .setParameter("target", to)
                .setParameter("text", target);

        HttpPost httpPost = new HttpPost(builder.build());
        httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        httpPost.setHeader("X-Naver-Client-Id", "yodcEtTf3WZtu3fyMI3L");
        httpPost.setHeader("X-Naver-Client-Secret", "__wHnJUvIL");

        StringEntity entity = new StringEntity("");
        httpPost.setEntity(entity);

        HttpEntity responseEntity = httpclient.execute(httpPost).getEntity();
        String responseString = EntityUtils.toString(responseEntity, "UTF-8");

        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> test = mapper.readValue(responseString, Map.class);

        Map<String, Object> result = (Map<String, Object>) ((Map<String, Object>) test.get("message")).get("result");

        return (String) result.get("translatedText");
    }
}
