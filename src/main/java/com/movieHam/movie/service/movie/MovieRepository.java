package com.movieHam.movie.service.movie;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;

import java.util.List;

@RepositoryDefinition(domainClass = Movie.class, idClass = Long.class)
public interface MovieRepository extends JpaRepository<Movie, Long> {

    <S extends Movie> List<S> saveAll(Iterable<S> movieList);

    Page<Movie> findAll(Pageable pageable);
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

    @Query("select m " +
            "from tn_movie m left join tn_wish w " +
            "on m.movieId = w.movieId and w.userId = :userId " +
            "where w.movieId is null")
    List<Movie> findAllNotClassified(Pageable pageable, Long userId);

    @Query("select m " +
            "from tn_movie m left join tn_wish w " +
            "on m.movieId = w.movieId and w.userId = :userId " +
            "where w.movieId is null and m.movieId = :queryParam")
    List<Movie> findByMovieIdContainsNotClassified(String queryParam, Pageable pageable, Long userId);

    @Query("select m " +
            "from tn_movie m left join tn_wish w " +
            "on m.movieId = w.movieId and w.userId = :userId " +
            "where w.movieId is null and m.adult = :queryParam")
    List<Movie> findByAdultContainsNotClassified(String queryParam, Pageable pageable, Long userId);

    @Query("select m " +
            "from tn_movie m left join tn_wish w " +
            "on m.movieId = w.movieId and w.userId = :userId " +
            "where w.movieId is null and m.originalLanguage like %:queryParam%")
    List<Movie> findByOriginalLanguageContainsNotClassified(String queryParam, Pageable pageable, Long userId);

    @Query("select m " +
            "from tn_movie m left join tn_wish w " +
            "on m.movieId = w.movieId and w.userId = :userId " +
            "where w.movieId is null and m.originalTitle like %:queryParam%")
    List<Movie> findByOriginalTitleContainsNotClassified(String queryParam, Pageable pageable, Long userId);

    @Query("select m " +
            "from tn_movie m left join tn_wish w " +
            "on m.movieId = w.movieId and w.userId = :userId " +
            "where w.movieId is null and m.overview like %:queryParam%")
    List<Movie> findByOverviewContainsNotClassified(String queryParam, Pageable pageable, Long userId);

    @Query("select m " +
            "from tn_movie m left join tn_wish w " +
            "on m.movieId = w.movieId and w.userId = :userId " +
            "where w.movieId is null and m.releaseDate = :queryParam")
    List<Movie> findByReleaseDateContainsNotClassified(String queryParam, Pageable pageable, Long userId);

    @Query(value = "select m " +
            "from tn_movie m left join tn_wish w " +
            "on m.movieId = w.movieId and w.userId = :userId " +
            "where w.movieId is null and date_format(m.releaseDate, '%Y') = :queryParam" , nativeQuery = true)
    List<Movie> findByReleaseYearContainsNotClassified(String queryParam, Pageable pageable, Long userId);

    @Query("select m " +
            "from tn_movie m left join tn_wish w " +
            "on m.movieId = w.movieId and w.userId = :userId " +
            "where w.movieId is null and m.title like %:queryParam%")
    List<Movie> findByTitleContainsNotClassified(String queryParam, Pageable pageable, Long userId);

}
