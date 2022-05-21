package com.movieHam.movie.service.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public List<MovieVO> selectByTitle(String title) {

        return movieRepository.findByTitleLike(title);
    }

    public void saveAll(ArrayList<MovieVO> movieBeanList) {

        movieRepository.saveAll(movieBeanList);
    }
}
