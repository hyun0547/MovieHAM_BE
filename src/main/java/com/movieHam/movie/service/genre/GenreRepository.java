package com.movieHam.movie.service.genre;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@RepositoryDefinition(domainClass = Genre.class, idClass = String.class)
public interface GenreRepository extends JpaRepository<Genre, String> {

}
