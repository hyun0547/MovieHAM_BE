package com.movieHam.movie.service.wish;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;

import java.util.List;

@RepositoryDefinition(domainClass = WishVO.class, idClass = String.class)
public interface WishRepository extends JpaRepository<WishVO, String> {


    <S extends WishVO> List<S> saveAll(Iterable<S> movieList);

    List<WishVO> findAll();
}
