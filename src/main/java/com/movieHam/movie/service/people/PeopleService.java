package com.movieHam.movie.service.people;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.StringHandler;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.util.List;

@Service
public class PeopleService {

    @Autowired
    PeopleRepository peopleRepository;

    public List<People> allList() {
        return peopleRepository.findAll();
    }

    public void insert(People people) {
        peopleRepository.save(people);
    }

    public void saveAll(List<People> peopleList) {
        peopleRepository.saveAll(peopleList);
        peopleRepository.flush();
    }

    public List<People> search(String searchType, String keyword) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        String firstUpperWord = StringHandler.firstLetterUpperCase(searchType);

        Class repositoryBean = peopleRepository.getClass();
        Method m = repositoryBean.getMethod("findBy" + firstUpperWord + "Contains", String.class);

        List<People> resultList = (List<People>) m.invoke(peopleRepository, keyword);

        return resultList;
    }
}
