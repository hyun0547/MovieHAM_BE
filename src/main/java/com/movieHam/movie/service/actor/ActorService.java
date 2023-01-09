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

    public List<ActorVO> allList() {
        return actorRepository.findAll();
    }

    public void insert(ActorVO actor) {
        actorRepository.save(actor);
    }

    public void saveAll(List<ActorVO> actorList) {
        actorRepository.saveAll(actorList);
    }

    public List<ActorVO> search(String searchType, String keyword) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        String firstUpperWord = StringHandler.firstLetterUpperCase(searchType);

        Class repositoryBean = actorRepository.getClass();
        Method m = repositoryBean.getMethod("findBy" + firstUpperWord + "Contains", String.class);

        List<ActorVO> resultList = (List<ActorVO>) m.invoke(actorRepository, keyword);

        return resultList;
    }
}
