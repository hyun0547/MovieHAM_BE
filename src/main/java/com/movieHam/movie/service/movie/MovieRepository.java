package com.movieHam.movie.service.movie;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;
import java.util.List;

@RepositoryDefinition(domainClass = Movie.class, idClass = String.class)
public interface MovieRepository extends JpaRepository<Movie, String> {

    <S extends Movie> List<S> saveAll(Iterable<S> movieList);

}
