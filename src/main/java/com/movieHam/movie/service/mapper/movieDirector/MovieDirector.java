package com.movieHam.movie.service.mapper.movieDirector;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.movieHam.movie.service.director.Director;
import com.movieHam.movie.service.movie.Movie;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name= "TM_MOVIE_DIRECTOR")
public class MovieDirector {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cntNo;

    @ManyToOne
    @JoinColumn(name = "docid")
    @JsonBackReference
    private Movie movie;

    @ManyToOne
    @JoinColumn(name="director_id")
    @JsonManagedReference
    private Director director;
}
