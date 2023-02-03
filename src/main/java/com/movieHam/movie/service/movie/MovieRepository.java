package com.movieHam.movie.service.movie;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;
import java.util.List;

@RepositoryDefinition(domainClass = Movie.class, idClass = String.class)
public interface MovieRepository extends JpaRepository<Movie, String> {

    List<Movie> findAll();

    <S extends Movie> List<S> saveAll(Iterable<S> movieList);

    Movie getById(String Id);

    List<Movie> findByTitleContains(String title);
    List<Movie> findByTitleContainsAndPostersIsNotNull(String queryParam);
    List<Movie> findByTitleContainsAndPostersIsNotNull(String queryParam, Pageable pageable);

    List<Movie> findByRatingContains(String queryParam);
    List<Movie> findByRatingContainsAndPostersIsNotNull(String queryParam);
    List<Movie> findByRatingContainsAndPostersIsNotNull(String queryParam, Pageable pageable);

    List<Movie> findByGenreContains(String queryParam);
    List<Movie> findByGenreContainsAndPostersIsNotNull(String queryParam);
    List<Movie> findByGenreContainsAndPostersIsNotNull(String queryParam, Pageable pageable);

    List<Movie> findByTypeContains(String queryParam);
    List<Movie> findByTypeContainsAndPostersIsNotNull(String queryParam);
    List<Movie> findByTypeContainsAndPostersIsNotNull(String queryParam, Pageable pageable);

    List<Movie> findByRepRlsDateContains(String queryParam);
    List<Movie> findByRepRlsDateContainsAndPostersIsNotNull(String queryParam);
    List<Movie> findByRepRlsDateContainsAndPostersIsNotNull(String queryParam, Pageable pageable);

    List<Movie> findByKeywordsContains(String queryParam);
    List<Movie> findByKeywordsContainsAndPostersIsNotNull(String queryParam);
    List<Movie> findByKeywordsContainsAndPostersIsNotNull(String queryParam, Pageable pageable);

    List<Movie> findByMovieSeqContains(String movieSeq);
    List<Movie> findByMovieSeqContainsAndPostersIsNotNull(String queryParam);
    List<Movie> findByMovieSeqContainsAndPostersIsNotNull(String queryParam, Pageable pageable);

    List<Movie> findByDocidContains(String docid);
    List<Movie> findByDocidContainsAndPostersIsNotNull(String queryParam);
    List<Movie> findByDocidContainsAndPostersIsNotNull(String queryParam, Pageable pageable);

    List<Movie> findByNationContains(String nation);
    List<Movie> findByNationContainsAndPostersIsNotNull(String queryParam);
    List<Movie> findByNationContainsAndPostersIsNotNull(String queryParam, Pageable pageable);
}
