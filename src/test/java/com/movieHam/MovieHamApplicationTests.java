package com.movieHam;


import com.movieHam.movie.service.movie.Movie;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@SpringBootTest
class MovieHamApplicationTests {

	public static void main(String[] args) {
		UUID uuid = UUID.randomUUID();
		int l = ByteBuffer.wrap(uuid.toString().getBytes()).getInt();
		System.out.println(Integer.toString(l, 9));
	}

}
