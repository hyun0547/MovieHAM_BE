package com.movieHam.movie.service.movie;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.movieHam.movie.service.mapper.movieGenre.MovieGenre;
import com.movieHam.movie.service.mapper.moviePeople.MoviePeople;
import lombok.Getter;
import lombok.Setter;
import util.com.CommonUtil;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Getter
@Setter
@Entity(name= "tn_movie")
public class Movie {

    @Id
    private Integer movieId;

    private boolean adult;
    private String backdropPath;
    private String originalLanguage;
    private String originalTitle;
    private String overview;
    private double popularity;
    private String posterPath;
    private Date releaseDate;
    private String title;
    private double voteAverage;
    private Integer voteCount;



    @OneToMany(mappedBy = "movie")
    @JsonManagedReference
    private List<MoviePeople> moviePeople;

    @OneToMany(mappedBy = "movie")
    @JsonManagedReference
    private List<MovieGenre> movieGenre;

    public String getPosterPath(){
        return posterPath != null ? "https://image.tmdb.org/t/p/original" + posterPath : null;
    }

    public String getBackdropPath(){
        return backdropPath != null ? "https://image.tmdb.org/t/p/original" + backdropPath : null;
    }
}
