package com.movieHam.movie.service.genre;

import com.movieHam.movie.service.movie.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import util.StringHandler;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@Service
public class GenreService {

    @Autowired
    GenreRepository genreRepository;

    public List<Genre> allList() {
        return genreRepository.findAll();
    }

    public void insert(Genre genre) {
        genreRepository.save(genre);
    }

    public void saveAll(List<Genre> genreList) {
        genreRepository.saveAll(genreList);
        genreRepository.flush();
    }

    public List<Genre> search(String searchType, String keyword, Integer pageIndex, Integer countPerPage) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        String firstUpperWord = StringHandler.firstLetterUpperCase(searchType);
        List<Genre> resultList;
        PageRequest pageRequest = null;
        Method m = null;

        Class repositoryBean = genreRepository.getClass();
        if(pageIndex != null && countPerPage != null){
            m = repositoryBean.getMethod("findBy" + firstUpperWord + "Contains", String.class, Pageable.class);
            pageRequest = PageRequest.of(pageIndex, countPerPage);
            resultList = (List<Genre>) m.invoke(genreRepository, keyword, pageRequest);
        }else{
            m = repositoryBean.getMethod("findBy" + firstUpperWord + "Contains", String.class);
            resultList = (List<Genre>) m.invoke(genreRepository, keyword);
        }

        return resultList;
    }
}
