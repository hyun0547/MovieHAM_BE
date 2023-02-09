package com.movieHam.movie.service.wish;

import com.movieHam.movie.service.movie.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;

import java.util.List;

@RepositoryDefinition(domainClass = Movie.class, idClass = String.class)
public interface WishRepository extends JpaRepository<Movie, String> {


    <S extends Movie> List<S> saveAll(Iterable<S> movieList);


}
