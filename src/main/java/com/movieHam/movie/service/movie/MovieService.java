package com.movieHam.movie.service.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public List<MovieVO> search(String searchType, String queryParam) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        List<MovieVO> resultList = null;

        Map<String, Object> map = new HashMap<String, Object>(){
            {
                put("title", movieRepository.findByTitleContains(queryParam));
                put("nation", movieRepository.findByNationContains(queryParam));
            }
        };

        String first = searchType.substring(0, 1).toUpperCase();
        String remain = searchType.substring(1);
        searchType = first + remain;

        Class test = MovieRepository.class;
        Method m = test.getMethod("findBy" + searchType + "Contains", String.class);
        resultList = (List<MovieVO>) m.invoke(movieRepository, queryParam);

        return resultList;
    }

    public void insertAll(ArrayList<MovieVO> movieBeanList) {

        movieRepository.saveAll(movieBeanList);
    }

}
