package com.movieHam;


import com.movieHam.movie.service.movie.Movie;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class MovieHamApplicationTests {

	public static void main(String[] args) {
		System.out.println("테 스트".matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*"));
	}

}
