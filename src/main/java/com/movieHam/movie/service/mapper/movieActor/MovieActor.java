package com.movieHam.movie.service.mapper.movieActor;

import com.movieHam.movie.service.actor.ActorVO;
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

//    private String docid;            // 영화코드
//    private String actorId;          // 배우코드

    @ManyToOne
    @JoinColumn(name = "docid")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "actor_id")
    private ActorVO actor;

}
