package com.movieHam.movie.service.mapper.movieActor;

import com.movieHam.movie.service.movie.MovieVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;

import java.util.List;

@RepositoryDefinition(domainClass = MovieActor.class, idClass = String.class)
public interface MovieActorRepository extends JpaRepository<MovieActor, String> {

    <S extends MovieActor> List<S> saveAll(Iterable<S> movieActorList);

}
