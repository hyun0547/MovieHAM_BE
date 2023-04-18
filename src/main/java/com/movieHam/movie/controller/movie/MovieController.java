package com.movieHam.movie.controller.movie;

import com.movieHam.movie.service.com.SearchVO;
import com.movieHam.movie.service.genre.GenreService;
import com.movieHam.movie.service.people.PeopleService;
import com.movieHam.movie.service.movie.MovieDTO;
import com.movieHam.movie.service.movie.MovieService;
import com.movieHam.movie.service.movie.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import util.com.CommonUtil;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

@RestController
public class MovieController {

    @Autowired
    MovieService movieService;

    @Autowired
    PeopleService peopleService;

    @Autowired
    GenreService genreService;

    @PostMapping(value="/movie/{movieId}", produces = "application/json; charset=UTF-8")
    public Map<String,Object> search(@PathVariable Integer movieId) {

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
    public Map<String,Object> searchList(@RequestBody SearchVO searchVO, @PathVariable String group, @PathVariable String order) {

        Map<String,Object> result;

        try {

            Set<MovieDTO> resultSet = new LinkedHashSet<>();
            List<Movie> movieList;

            searchVO.setOrder(order);
            searchVO.setGroup(group);

            if("".equals(CommonUtil.checkNullEmpty(searchVO.getClassifiedYn(), ""))){
                movieList = movieService.searchList(searchVO);
            }else{
                if(searchVO.isClassified()){
                    movieList = movieService.searchClassifiedList(searchVO);
                }else{
                    movieList = movieService.searchNotClassifiedList(searchVO);
                }
            }

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

}
