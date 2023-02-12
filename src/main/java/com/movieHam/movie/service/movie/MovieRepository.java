package com.movieHam.movie.service.movie;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;
import java.util.List;

@RepositoryDefinition(domainClass = Movie.class, idClass = Long.class)
public interface MovieRepository extends JpaRepository<Movie, Long> {

    <S extends Movie> List<S> saveAll(Iterable<S> movieList);

    List<Movie> findByReleaseDateContainsAndPosterPathIsNotNull(String queryParam);
    List<Movie> findByReleaseDateContainsAndPosterPathIsNotNull(String queryParam, Pageable pageable);

    List<Movie> findByTitleContainsAndPosterPathIsNotNull(String queryParam);
    List<Movie> findByTitleContainsAndPosterPathIsNotNull(String queryParam, Pageable pageable);

    List<Movie> findByVoteAverageContainsAndPosterPathIsNotNull(String queryParam);
    List<Movie> findByVoteAverageContainsAndPosterPathIsNotNull(String queryParam, Pageable pageable);

    List<Movie> findByOriginalLanguageContainsAndPosterPathIsNotNull(String queryParam);
    List<Movie> findByOriginalLanguageContainsAndPosterPathIsNotNull(String queryParam, Pageable pageable);

}
