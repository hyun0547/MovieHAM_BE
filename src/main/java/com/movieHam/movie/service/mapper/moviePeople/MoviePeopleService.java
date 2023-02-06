package com.movieHam.movie.service.mapper.moviePeople;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MoviePeopleService {

    @Autowired
    MoviePeopleRepository movieRepository;

    public void saveAll(ArrayList<MoviePeople> moviePeopleList){
        movieRepository.saveAll(moviePeopleList);
    }
}
