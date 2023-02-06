package com.movieHam;

import com.fasterxml.jackson.databind.ObjectMapper;
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

//	public static void main(String[] args) {
//		SpringApplication.run(MovieHamApplication.class, args);
//	}

	public static void main(String[] args) throws Exception {
		Map<String,String> paramMap = new HashMap<>(){{
			put("language", "ko");
			put("page", "1");
			put("api_key", "de0b88f9a20412d77f2029f0ce308f89");      // required parameter
		}};

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

	}

}
