package com.movieHam.movie.service.actor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.StringHandler;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.util.List;

@Service
public class ActorService {

    @Autowired
    ActorRepository actorRepository;

    public List<Actor> allList() {
        return actorRepository.findAll();
    }

    public void insert(Actor actor) {
        actorRepository.save(actor);
    }

    public void saveAll(List<Actor> actorList) {
        actorRepository.saveAll(actorList);
        actorRepository.flush();
    }

    public List<Actor> search(String searchType, String keyword) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        String firstUpperWord = StringHandler.firstLetterUpperCase(searchType);

        Class repositoryBean = actorRepository.getClass();
        Method m = repositoryBean.getMethod("findBy" + firstUpperWord + "Contains", String.class);

        List<Actor> resultList = (List<Actor>) m.invoke(actorRepository, keyword);

        return resultList;
    }
}
