package com.movieHam.movie.service.director;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DirectorService {

    @Autowired
    DirectorRepository directorRepository;

    public void insert(DirectorVO director){
        directorRepository.save(director);
    }

    public void saveAll(ArrayList<DirectorVO> directorList){
        directorRepository.saveAll(directorList);
    }

    public ArrayList<DirectorVO> search(String directorNm) {
        DirectorVO director = new DirectorVO();
        director.setDirectorNm(directorNm);
        return directorRepository.findByDirectorNmContains(director.getDirectorNm());
    }
}
