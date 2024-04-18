package com.movieHam.movie.service;

import java.util.List;
import java.util.Optional;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService{

    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> getMovieList(MovieSearch movieParam, String searchType) {

        List<Movie> movieList = null;

        switch (searchType) {
            case "title":
                movieList = movieRepository.findByTitleContaining(movieParam.getTitle());
                break;

            case "date":
                Date fromDate = movieParam.getFromDate();
                Date toDate = movieParam.getToDate();

                if (fromDate == null && toDate != null) {
                    movieList = movieRepository.findByReleaseDateLessThan(toDate);
                } else if (fromDate != null && toDate == null) {
                    movieList = movieRepository.findByReleaseDateGreaterThan(fromDate);
                } else {
                    movieList = movieRepository.findByReleaseDateBetween(fromDate, toDate);
                }
                break;

            default:
                // 
                return null;
        }
        
        return movieList;
    }

    @Override
    public Movie getMovie(Integer id) {
        Optional<Movie> test = movieRepository.findById(id);
        return test.orElse(null);
    }

}
