package com.movieHam.movie.service.movie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;
import java.util.List;

@RepositoryDefinition(domainClass = Movie.class, idClass = String.class)
public interface MovieRepository extends JpaRepository<Movie, String> {

    List<Movie> findAll();

    <S extends Movie> List<S> saveAll(Iterable<S> movieList);

    Movie getById(String Id);

    List<Movie> findByNationContains(String nation);

    List<Movie> findByTitleContains(String title);

    List<Movie> findByRatingContains(String queryParam);

    List<Movie> findByGenreContains(String queryParam);

    List<Movie> findByTypeContains(String queryParam);

    List<Movie> findByRepRlsDateContains(String queryParam);

    List<Movie> findByKeywordsContains(String queryParam);

    List<Movie> findByMovieSeqContains(String movieSeq);

    List<Movie> findByDocidContains(String docid);

}
