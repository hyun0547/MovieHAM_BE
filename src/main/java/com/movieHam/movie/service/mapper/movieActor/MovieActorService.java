package com.movieHam.movie.service.mapper.movieActor;

import com.movieHam.movie.service.movie.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MovieActorService {

    @Autowired
    MovieActorRepository movieRepository;

    public void saveAll(ArrayList<MovieActor> movieActorList){
        movieRepository.saveAll(movieActorList);
    }
}
