package com.movieHam.movie.service.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    public List<Movie> search(String searchType, String keyword, String required,
                              Integer pageIndex, Integer countPerPage) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        String firstUpperWord = StringHandler.firstLetterUpperCase(searchType);
        required = "".equals(CommonUtil.checkNullEmpty(required,"")) ? "" : "And" + StringHandler.firstLetterUpperCase(required) + "IsNotNull";

        Class repositoryBean = movieRepository.getClass();
        List<Movie> resultList;
        PageRequest pageRequest = null;
        Method m = null;

        if(pageIndex != null && countPerPage != null){
            m = repositoryBean.getMethod("findBy" + firstUpperWord + "Contains" + required, String.class, Pageable.class);
            pageRequest = PageRequest.of(pageIndex, countPerPage);
            resultList = (List<Movie>) m.invoke(movieRepository, keyword, pageRequest);
        }else{
            m = repositoryBean.getMethod("findBy" + firstUpperWord + "Contains" + required, String.class);
            resultList = (List<Movie>) m.invoke(movieRepository, keyword);
        }

        return resultList;
    }

    public void saveAll(List<Movie> movieBeanList) {
        movieRepository.saveAll(movieBeanList);
        movieRepository.flush();
    }

}
