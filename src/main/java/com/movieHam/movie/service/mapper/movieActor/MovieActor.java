package com.movieHam.movie.service.mapper.movieActor;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.movieHam.movie.service.actor.Actor;
import com.movieHam.movie.service.movie.Movie;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Mapping table for Movie and Actor
 */

@Getter
@Setter
@Entity(name= "TM_MOVIE_ACTOR")
public class MovieActor {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cntNo;

    @ManyToOne
    @JoinColumn(name = "docid")
    @JsonBackReference
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "actor_id")
    @JsonManagedReference
    private Actor actor;

}
