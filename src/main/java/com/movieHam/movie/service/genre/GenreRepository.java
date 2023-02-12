package com.movieHam.movie.service.genre;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@RepositoryDefinition(domainClass = Genre.class, idClass = String.class)
public interface GenreRepository extends JpaRepository<Genre, String> {

    <S extends Genre> List<S> saveAll(Iterable<S> genreList);

    List<Genre> findByNameContains(String queryParam);
    List<Genre> findByNameContains(String queryParam, Pageable pageable);

}
