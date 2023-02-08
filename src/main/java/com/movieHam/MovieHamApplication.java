package com.movieHam;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.movieHam.externalApi.movie.TmdbApiService;
import com.movieHam.externalApi.movie.co.KMDB_API_DATA;
import com.movieHam.externalApi.movie.co.TMDB_API_DATA;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import util.parser.http.ConnectionHandler;
import util.parser.map.MapHandler;

import javax.net.ssl.HttpsURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class MovieHamApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieHamApplication.class, args);
	}

//	public static void main(String[] args) throws Exception {
//		TmdbApiService tmdbApi = new TmdbApiService();
//
//		Map<String,String> paramMap = new HashMap<String,String>(){
//			{
//				put("language", "ko");
//				put("page", "1");
//			}
//		};
//
//		Map<String,Object> resultMap = tmdbApi.tmdbNowPlayingMovies(paramMap);
//
//	}

}
