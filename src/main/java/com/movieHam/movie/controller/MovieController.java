package com.movieHam.movie.controller;

import com.movieHam.movie.service.people.PeopleService;
import com.movieHam.movie.service.people.People;
import com.movieHam.movie.service.mapper.moviePeople.MoviePeople;
import com.movieHam.movie.service.movie.MovieDTO;
import com.movieHam.movie.service.movie.MovieService;
import com.movieHam.movie.service.movie.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import util.StringHandler;
import util.com.CommonUtil;

import javax.servlet.http.HttpSession;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

@RestController
public class MovieController {

    @Autowired
    MovieService movieService;

    @Autowired
    PeopleService peopleService;

    @GetMapping(value="/movieHam/api/movie/search/{searchType}", produces = "application/json; charset=UTF-8")
    public Map<String,Object> search(HttpSession session, @PathVariable String searchType,
                                     String keywords, String required,
                                     Integer pageIndex, Integer countPerPage
    ) {

        System.out.println(session.getAttribute("user"));

        Map<String,Object> result;

        if(CommonUtil.checkNullEmpty(keywords, "").equals("")){
            return new HashMap<>(){{
                put("error", "키워드 누락");
            }};
        }

        try {

            Set<MovieDTO> resultList = new LinkedHashSet<>();

            if(CommonUtil.checkNullEmpty(searchType, "").contains("people")){
                List<People> peopleList = peopleService.search(searchType, keywords);
                for(People people : peopleList){
                    if(people.getMoviePeople() != null){
                        for(MoviePeople moviePeople : people.getMoviePeople()){
                            MovieDTO movieDTO = new MovieDTO(moviePeople.getMovie());
                            resultList.add(movieDTO);
                        }
                    }
                }

            }else{
                List<Movie> movieList = movieService.search(searchType, keywords, required, pageIndex, countPerPage);
                for(Movie movie : movieList){
                    MovieDTO movieDTO = new MovieDTO(movie);
                    resultList.add(movieDTO);
                }
            }

            Set<MovieDTO> resultSet = new LinkedHashSet<>(resultList);
            result = new HashMap<>(){{
                put("resultList", resultSet);
            }};

        }catch (NoSuchMethodException e){
            result = new HashMap<>(){{
                put("error", "검색형식 오류");
            }};
        } catch (InvocationTargetException e) {
            result = new HashMap<>(){{
                put("error", e.getMessage());
            }};
        } catch (IllegalAccessException e) {
            result = new HashMap<>(){{
                put("error", e.getMessage());
            }};
        }

        return result;
    }



}
