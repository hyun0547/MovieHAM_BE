package com.movieHam.movie.service.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.StringHandler;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public List<Movie> search(String searchType, String keyword) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        String firstUpperWord = StringHandler.firstLetterUpperCase(searchType);

        Class repositoryBean = movieRepository.getClass();

        Method m = repositoryBean.getMethod("findBy" + firstUpperWord + "Contains", String.class);

        List<Movie> resultList = (List<Movie>) m.invoke(movieRepository, keyword);

        return resultList;
    }

    public void saveAll(List<Movie> movieBeanList) {
        movieRepository.saveAll(movieBeanList);
    }

}
