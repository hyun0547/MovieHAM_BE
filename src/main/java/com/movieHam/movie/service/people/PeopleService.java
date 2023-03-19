package com.movieHam.movie.service.people;

import com.movieHam.externalApi.translation.Papago;
import com.movieHam.movie.service.movie.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import util.StringHandler;
import util.com.CommonUtil;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.net.URISyntaxException;
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

    public void translateAll() throws IOException, URISyntaxException {
        PageRequest pageRequest = PageRequest.of(0, 100);
        List<People> translateList = peopleRepository.findByNameContainsEn(pageRequest);
        for (People people : translateList){
            people.setName(Papago.translate(people.getName(), "en", "ko"));
        }
        peopleRepository.saveAll(translateList);
    }
}
