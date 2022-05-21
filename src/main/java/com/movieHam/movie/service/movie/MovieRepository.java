package com.movieHam.movie.service.movie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;
import java.util.List;

@RepositoryDefinition(domainClass = MovieVO.class, idClass = String.class)
public interface MovieRepository extends JpaRepository<MovieVO, String> {

    List<MovieVO> findAll();

    <S extends MovieVO> List<S> saveAll(Iterable<S> movieList);

    MovieVO getById(String Id);

    List<MovieVO> findByTitleLike(String title);
}
