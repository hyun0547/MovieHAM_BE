package com.movieHam.movie.service.mapper.movieDirector;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;

import java.util.List;

@RepositoryDefinition(domainClass = MovieDirector.class, idClass = String.class)
public interface MovieDirectorRepository extends JpaRepository<MovieDirector, String> {

    <S extends MovieDirector> List<S> saveAll(Iterable<S> movieDirectorList);

}
