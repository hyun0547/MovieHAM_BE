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

    public List<MovieVO> search(String searchType, String keyword) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        String firstUpperWord = StringHandler.firstLetterUpperCase(searchType);

        Class movieRepositoryBean = MovieRepository.class;
        Method m = movieRepositoryBean.getMethod("findBy" + firstUpperWord + "Contains", String.class);

        //regex 허용하는지 확인 필요
        List<MovieVO> resultList = (List<MovieVO>) m.invoke(movieRepository, keyword);

        return resultList;
    }

    public void insertAll(ArrayList<MovieVO> movieBeanList) {
        movieRepository.saveAll(movieBeanList);
    }

}
