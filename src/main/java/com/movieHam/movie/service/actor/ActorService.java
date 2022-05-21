package com.movieHam.movie.service.actor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
