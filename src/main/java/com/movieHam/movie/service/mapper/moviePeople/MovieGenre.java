package com.movieHam.movie.service.mapper.moviePeople;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.movieHam.movie.service.genre.Genre;
import com.movieHam.movie.service.movie.Movie;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@NoArgsConstructor
@Entity(name= "tm_movie_genre")
public class MovieGenre {

    public MovieGenre(Movie movie, Genre genre){
        this.movie = movie;
        this.genre = genre;
        this.movieGenreId = String.valueOf(movie.getMovieId()) + String.valueOf(genre.getGenreId());
    }

    @Id
    private String movieGenreId;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    @JsonBackReference
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    @JsonManagedReference
    private Genre genre;

}
