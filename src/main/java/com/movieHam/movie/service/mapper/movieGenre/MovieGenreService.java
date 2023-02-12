package com.movieHam.movie.service.mapper.movieGenre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieGenreService {

    @Autowired
    MovieGenreRepository movieGenreRepository;

    public void saveAll(List<MovieGenre> movieGenreList){
        movieGenreRepository.saveAll(movieGenreList);
    }
}
