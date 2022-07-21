package com.movieHam.movie.service.movie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;
import java.util.List;

@RepositoryDefinition(domainClass = MovieVO.class, idClass = String.class)
public interface MovieRepository extends JpaRepository<MovieVO, String> {

    List<MovieVO> findAll();

    <S extends MovieVO> List<S> saveAll(Iterable<S> movieList);

    MovieVO getById(String Id);

    List<MovieVO> findByNationContains(String nation);

    List<MovieVO> findByTitleContains(String title);

    List<MovieVO> findByRatingContains(String queryParam);

    List<MovieVO> findByGenreContains(String queryParam);

    List<MovieVO> findByTypeContains(String queryParam);

    List<MovieVO> findByActorIdContains(String queryParam);

    List<MovieVO> findByDirectorIdContains(String queryParam);

    List<MovieVO> findByRepRlsDateContains(String queryParam);

    List<MovieVO> findByKeywordsContains(String queryParam);

    List<MovieVO> findByMovieSeqContains(String movieSeq);

    List<MovieVO> findByDocidContains(String docid);

}
