package com.movieHam.movie.service.movie;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;
import java.util.List;

@RepositoryDefinition(domainClass = Movie.class, idClass = Long.class)
public interface MovieRepository extends JpaRepository<Movie, Long> {

    <S extends Movie> List<S> saveAll(Iterable<S> movieList);

    List<Movie> findByMovieIdContains(String queryParam, Pageable pageable);
    List<Movie> findByAdultContains(String queryParam, Pageable pageable);
    List<Movie> findByBackdropPathContains(String queryParam, Pageable pageable);
    List<Movie> findByOriginalLanguageContains(String queryParam, Pageable pageable);
    List<Movie> findByOriginalTitleContains(String queryParam, Pageable pageable);
    List<Movie> findByOverviewContains(String queryParam, Pageable pageable);
    List<Movie> findByPopularityContains(String queryParam, Pageable pageable);
    List<Movie> findByPosterPathContains(String queryParam, Pageable pageable);
    List<Movie> findByReleaseDateContains(String queryParam, Pageable pageable);
    List<Movie> findByTitleContains(String queryParam, Pageable pageable);
    List<Movie> findByVoteAverageContains(String queryParam, Pageable pageable);
    List<Movie> findByVoteCountContains(String queryParam, Pageable pageable);

}
