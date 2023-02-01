package com.movieHam.movie.service.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.StringHandler;
import util.com.CommonUtil;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public List<Movie> search(String searchType, String keyword, String required) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        String firstUpperWord = StringHandler.firstLetterUpperCase(searchType);

        Class repositoryBean = movieRepository.getClass();

        required = "".equals(CommonUtil.checkNullEmpty(required,"")) ? "" : "And" + StringHandler.firstLetterUpperCase(required) + "IsNotNull";
        Method m = repositoryBean.getMethod("findBy" + firstUpperWord + "Contains" + required, String.class);

        List<Movie> resultList = (List<Movie>) m.invoke(movieRepository, keyword);

        return resultList;
    }

    public void saveAll(List<Movie> movieBeanList) {
        movieRepository.saveAll(movieBeanList);
        movieRepository.flush();
    }

}
