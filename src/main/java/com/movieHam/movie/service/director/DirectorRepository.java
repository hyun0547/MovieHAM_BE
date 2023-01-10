package com.movieHam.movie.service.director;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@RepositoryDefinition(domainClass = Director.class, idClass = String.class)
public interface DirectorRepository extends JpaRepository<Director, String> {
    List<Director> findAll();

    ArrayList<Director> findByDirectorNmContains(String directorNm);
}
