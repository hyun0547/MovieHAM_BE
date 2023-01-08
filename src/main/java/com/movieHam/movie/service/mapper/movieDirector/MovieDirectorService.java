package com.movieHam.movie.service.mapper.movieDirector;

import com.movieHam.movie.service.mapper.movieActor.MovieActor;
import com.movieHam.movie.service.mapper.movieActor.MovieActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MovieDirectorService {

    @Autowired
    MovieDirectorRepository movieDirectorRepository;

    public void saveAll(ArrayList<MovieDirector> movieDirectorList){
        movieDirectorRepository.saveAll(movieDirectorList);
    }
}
