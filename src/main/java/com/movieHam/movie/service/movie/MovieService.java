package com.movieHam.movie.service.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.StringHandler;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public List<MovieVO> search(String searchType, String... keywords) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        String firstUpperWord = StringHandler.firstLetterUpperCase(searchType);

        Class test = MovieRepository.class;
        Method m = test.getMethod("findBy" + firstUpperWord + "Contains", String.class);

        //regex 허용하는지 확인 필요
        String keywordRegex = Arrays.stream(keywords).collect(Collectors.joining("|"));

        List<MovieVO> resultList = (List<MovieVO>) m.invoke(movieRepository, keywordRegex);

        return resultList;
    }

    public void insertAll(ArrayList<MovieVO> movieBeanList) {
        movieRepository.saveAll(movieBeanList);
    }

}
