package com.movieHam.movie.service.movie;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;

import java.util.List;

@RepositoryDefinition(domainClass = Movie.class, idClass = Integer.class)
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    <S extends Movie> List<S> saveAll(Iterable<S> movieList);

    List<Movie> findAll();
    Page<Movie> findAll(Pageable pageable);
    List<Movie> findByMovieId(String queryParam, Pageable pageable);
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

    @Query(value = "select m.* " +
            "from tn_movie m " +
            "left join tm_movie_genre tmg on m.movie_id = tmg.movie_id " +
            "left join tn_genre tg on tmg.genre_id = tg.genre_id " +
            "where tg.name = :queryParam" +
            "group by m.movie_id"
            , nativeQuery = true)
    List<Movie> findByGenreContains(String queryParam, Pageable pageable);

    @Query(value = "select m.* " +
            "from tn_movie m " +
            "left join tm_movie_people tmp on m.movie_id = tmp.movie_id " +
            "left join tn_people tp on tp.people_id = tmp.people_id " +
            "where tp.known_for_department = 'Acting' " +
            "and tp.name like %:queryParam% " +
            "group by m.movie_id"
            , nativeQuery = true)
    List<Movie> findByActorContains(String queryParam, Pageable pageable);

    @Query(value = "select m.* " +
            "from tn_movie m " +
            "left join tm_movie_people tmp on m.movie_id = tmp.movie_id " +
            "left join tn_people tp on tp.people_id = tmp.people_id " +
            "where tp.known_for_department = 'Directing' " +
            "and tp.name like %:queryParam% " +
            "group by m.movie_id"
            , nativeQuery = true)
    List<Movie> findByDirectorContains(String queryParam, Pageable pageable);

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

    @Query(value = "select * " +
            "from tn_movie m left join tn_wish w " +
            "on m.movie_id = w.movie_id and w.user_id = :userId " +
            "where w.movie_id is null and date_format(m.release_date, '%Y') = :queryParam" , nativeQuery = true)
    List<Movie> findByReleaseYearContainsNotClassified(String queryParam, Pageable pageable, Long userId);

    @Query("select m " +
            "from tn_movie m left join tn_wish w " +
            "on m.movieId = w.movieId and w.userId = :userId " +
            "where w.movieId is null and m.title like %:queryParam%")
    List<Movie> findByTitleContainsNotClassified(String queryParam, Pageable pageable, Long userId);


    @Query(value = "select m.* " +
            "from tn_movie m " +
            "left join tm_movie_genre tmg on m.movie_id = tmg.movie_id " +
            "left join tn_genre tg on tmg.genre_id = tg.genre_id " +
            "left join tn_wish w on m.movie_id = w.movie_id and w.user_id = :userId " +
            "where w.movie_id is null " +
            "and tg.name = :queryParam"
            , nativeQuery = true)
    List<Movie> findByGenreContainsNotClassified(String queryParam, Pageable pageable, Long userId);

    @Query(value = "select m.* " +
            "from tn_movie m " +
            "left join tm_movie_people tmp on m.movie_id = tmp.movie_id " +
            "left join tn_people tp on tp.people_id = tmp.people_id " +
            "left join tn_wish w on m.movie_id = w.movie_id and w.user_id = :userId " +
            "where w.movie_id is null " +
            "and tp.known_for_department = 'Acting' " +
            "and tp.name like %:queryParam% " +
            "group by m.movie_id"
            , nativeQuery = true)
    List<Movie> findByActorContainsNotClassified(String queryParam, Pageable pageable, Long userId);

    @Query(value = "select m.* " +
            "from tn_movie m " +
            "left join tm_movie_people tmp on m.movie_id = tmp.movie_id " +
            "left join tn_people tp on tp.people_id = tmp.people_id " +
            "left join tn_wish w on m.movie_id = w.movie_id and w.user_id = :userId " +
            "where w.movie_id is null " +
            "and tp.known_for_department = 'Directing' " +
            "and tp.name like %:queryParam% " +
            "group by m.movie_id"
            , nativeQuery = true)
    List<Movie> findByDirectorContainsNotClassified(String queryParam, Pageable pageable, Long userId);
}
