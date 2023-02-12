package com.movieHam.movie.service.movie;

import com.movieHam.movie.service.genre.Genre;
import com.movieHam.movie.service.mapper.movieGenre.MovieGenre;
import com.movieHam.movie.service.people.People;
import com.movieHam.movie.service.mapper.moviePeople.MoviePeople;
import lombok.Getter;

import javax.persistence.Id;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Getter
public class MovieDTO {

    public MovieDTO (Movie movie){
        this.movieId = movie.getMovieId();
        this.adult = movie.isAdult();
        this.backdropPath = movie.getBackdropPath();
        this.originalLanguage = movie.getOriginalLanguage();
        this.originalTitle = movie.getOriginalTitle();
        this.overview = movie.getOverview();
        this.popularity = movie.getPopularity();
        this.posterPath = movie.getPosterPath();
        this.releaseDate = movie.getReleaseDate();
        this.title = movie.getTitle();
        this.voteAverage = movie.getVoteAverage();
        this.voteCount = movie.getVoteCount();

        genreList = new ArrayList<>();
        for(MovieGenre moviePeople : movie.getMovieGenre()){
            genreList.add(moviePeople.getGenre());
        }

        peopleList = new ArrayList<>();
        for(MoviePeople moviePeople : movie.getMoviePeople()){
            peopleList.add(moviePeople.getPeople());
        }

    }

    @Id
    private Integer movieId;            // 영화 아이디

    private boolean adult;
    private String backdropPath;        // 백드롭이미지
    private String originalLanguage;
    private String originalTitle;
    private String overview;            // 줄거리
    private double popularity;          // 인지도
    private String posterPath;          // 포스터이미지
    private Date releaseDate;         // 개봉일
    private String title;               // 제목
    private double voteAverage;         // 평점평균
    private Integer voteCount;           // 평가수


    List<People> peopleList;
    List<Genre> genreList;

    @Override
    public int hashCode() {
        return movieId.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof MovieDTO)) {
            return false;
        }

        MovieDTO movie = (MovieDTO)obj;

        return movieId.equals(movie.movieId);

    }
}
