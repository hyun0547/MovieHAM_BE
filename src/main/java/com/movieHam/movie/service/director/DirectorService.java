package com.movieHam.movie.service.director;

import com.movieHam.movie.service.actor.ActorRepository;
import com.movieHam.movie.service.actor.ActorVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DirectorService {

    @Autowired
    DirectorRepository directorRepository;

    public void insert(DirectorVO director){
        directorRepository.save(director);
    }

    public void insertAll(ArrayList<DirectorVO> directorList){
        directorRepository.saveAll(directorList);
    }
}
