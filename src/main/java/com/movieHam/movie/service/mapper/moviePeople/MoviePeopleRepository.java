package com.movieHam.movie.service.mapper.moviePeople;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;

import java.util.List;

@RepositoryDefinition(domainClass = MoviePeople.class, idClass = Long.class)
public interface MoviePeopleRepository extends JpaRepository<MoviePeople, Long> {

    <S extends MoviePeople> List<S> saveAll(Iterable<S> moviePeopleList);

}
