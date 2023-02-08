package com.movieHam.movie.service.genre;

import com.movieHam.movie.service.genre.Genre;
import com.movieHam.movie.service.genre.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public List<Genre> search(String searchType, String keyword) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        String firstUpperWord = StringHandler.firstLetterUpperCase(searchType);

        Class repositoryBean = genreRepository.getClass();
        Method m = repositoryBean.getMethod("findBy" + firstUpperWord + "Contains", String.class);

        List<Genre> resultList = (List<Genre>) m.invoke(genreRepository, keyword);

        return resultList;
    }
}
