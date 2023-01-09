package com.movieHam;


import com.movieHam.movie.service.movie.Movie;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class MovieHamApplicationTests {

	@Test
	void wishTest() {

		Movie movie = new Movie();
		List<Movie> movieList = new ArrayList<>();

		movie.setMovieId("test");
		movieList.add(movie);
		movie.setMovieId("test2");

		System.out.println(movieList.get(0));
	}

}
