package com.movieHam.movie.service.movie;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.movieHam.movie.service.genre.Genre;
import com.movieHam.movie.service.mapper.moviePeople.MovieGenre;
import com.movieHam.movie.service.mapper.moviePeople.MoviePeople;
import lombok.Getter;
import lombok.Setter;

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
}
