package com.movieHam.movie.service.mapper.movieGenre;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;

import java.util.List;

@RepositoryDefinition(domainClass = MovieGenre.class, idClass = Long.class)
public interface MovieGenreRepository extends JpaRepository<MovieGenre, Long> {

    <S extends MovieGenre> List<S> saveAll(Iterable<S> movieGenreList);

}
