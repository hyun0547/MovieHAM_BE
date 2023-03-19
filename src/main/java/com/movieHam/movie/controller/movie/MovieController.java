package com.movieHam.movie.controller.movie;

import com.movieHam.movie.service.genre.Genre;
import com.movieHam.movie.service.genre.GenreService;
import com.movieHam.movie.service.mapper.movieGenre.MovieGenre;
import com.movieHam.movie.service.people.PeopleService;
import com.movieHam.movie.service.people.People;
import com.movieHam.movie.service.mapper.moviePeople.MoviePeople;
import com.movieHam.movie.service.movie.MovieDTO;
import com.movieHam.movie.service.movie.MovieService;
import com.movieHam.movie.service.movie.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import util.StringHandler;
import util.com.CommonUtil;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.util.*;

@RestController
public class MovieController {

    @Autowired
    MovieService movieService;

    @Autowired
    PeopleService peopleService;

    @Autowired
    GenreService genreService;

    @GetMapping(value="/movie/{movieId}", produces = "application/json; charset=UTF-8")
    public Map<String,Object> searchList(HttpSession session, @PathVariable Integer movieId
    ) {

        Map<String,Object> result;

        Set<MovieDTO> resultSet = new LinkedHashSet<>();

        Movie movie = movieService.findMovieById(movieId);

        MovieDTO movieDTO = new MovieDTO(movie);
        resultSet.add(movieDTO);

        result = new HashMap<>(){{
            put("result", resultSet);
        }};

        return result;
    }

    @PostMapping(value="/movie/list/{group}/{order}", produces = "application/json; charset=UTF-8")
    public Map<String,Object> searchList(HttpSession session, @PathVariable String group, @PathVariable String order,
                                     String groupKeyword, String orderType, Integer pageIndex, Integer countPerPage
    ) {

        Map<String,Object> result;

        try {

            Set<MovieDTO> resultSet = new LinkedHashSet<>();

            List<Movie> movieList = movieService.searchList(group, groupKeyword, order, orderType, pageIndex, countPerPage);
            for(Movie movie : movieList){
                MovieDTO movieDTO = new MovieDTO(movie);
                resultSet.add(movieDTO);
            }

            result = new HashMap<>(){{
                put("result", resultSet);
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

    @PostMapping(value="/movie/notClassifiedList/{group}/{order}", produces = "application/json; charset=UTF-8")
    public Map<String,Object> searchNotClassifiedList(HttpSession session, @PathVariable String group, @PathVariable String order,
                                     String groupKeyword, String orderType, Integer pageIndex, Integer countPerPage, Long userId
    ) throws IOException, URISyntaxException {
//        peopleService.translateAll();

        Map<String,Object> result;

        try {

            Set<MovieDTO> resultSet = new LinkedHashSet<>();

            List<Movie> movieList = movieService.searchNotClassifiedList(group, groupKeyword, order, orderType, pageIndex, countPerPage, userId);
            for(Movie movie : movieList){
                MovieDTO movieDTO = new MovieDTO(movie);
                resultSet.add(movieDTO);
            }

            result = new HashMap<>(){{
                put("result", resultSet);
            }};

        }catch (NoSuchMethodException e){
            result = new HashMap<>(){{
                put("error", "검색형식 오류");
            }};
        } catch (InvocationTargetException e) {
            result = new HashMap<>(){{
                put("error", e.getCause());
            }};
        } catch (IllegalAccessException e) {
            result = new HashMap<>(){{
                put("error", e.getMessage());
            }};
        }

        return result;
    }

}
