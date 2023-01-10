package com.movieHam.movie.service.director;

import com.movieHam.movie.service.actor.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.StringHandler;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@Service
public class DirectorService {

    @Autowired
    DirectorRepository directorRepository;

    public void insert(Director director){
        directorRepository.save(director);
    }

    public void saveAll(ArrayList<Director> directorList){
        directorRepository.saveAll(directorList);
    }

    public List<Director> search(String searchType, String keyword) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        String firstUpperWord = StringHandler.firstLetterUpperCase(searchType);

        Class repositoryBean = directorRepository.getClass();
        Method m = repositoryBean.getMethod("findBy" + firstUpperWord + "Contains", String.class);

        List<Director> resultList = (List<Director>) m.invoke(directorRepository, keyword);

        return resultList;
    }
}
