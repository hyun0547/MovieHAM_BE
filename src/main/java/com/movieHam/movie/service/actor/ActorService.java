package com.movieHam.movie.service.actor;

import com.movieHam.movie.service.movie.MovieRepository;
import com.movieHam.movie.service.movie.MovieVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.StringHandler;

import java.lang.reflect.Method;
import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    public void insertAll(ArrayList<ActorVO> actorList) {
        actorRepository.saveAll(actorList);
    }

    public List<ActorVO> search(String keyword) {


        List<ActorVO> resultList = actorRepository.findByActorNmContains(keyword);

        return resultList;

    }
}
