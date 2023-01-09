package com.movieHam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MovieHamApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieHamApplication.class, args);
	}

//	public static void main(String[] args){
//		MovieVO movie = new MovieVO();
//		List<MovieVO> movieList = new ArrayList<>();
//
//		movie.setMovieId("test");
//		movieList.add(movie.clone());
//		movie.setMovieId("test2");
//
//		System.out.println(movieList.get(0));
//	}

}
