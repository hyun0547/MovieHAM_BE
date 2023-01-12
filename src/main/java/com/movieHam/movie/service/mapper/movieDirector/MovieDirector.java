package com.movieHam.movie.service.mapper.movieDirector;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.movieHam.movie.service.director.Director;
import com.movieHam.movie.service.movie.Movie;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity(name= "TM_MOVIE_DIRECTOR")
public class MovieDirector {

    public MovieDirector(Movie movie, Director director){
        this.movie = movie;
        this.director = director;
        this.movieDirectorId = this.movie.getDocid() + this.director.getDirectorId();
    }

    @Id
    private String movieDirectorId;

    @ManyToOne
    @JoinColumn(name = "docid")
    @JsonBackReference
    private Movie movie;

    @ManyToOne
    @JoinColumn(name="director_id")
    @JsonManagedReference
    private Director director;
}
