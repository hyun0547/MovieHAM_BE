package com.movieHam.movie.service.mapper.movieActor;

import com.movieHam.movie.service.actor.ActorVO;
import com.movieHam.movie.service.movie.MovieVO;
import lombok.Data;

import javax.persistence.*;

/**
 * Mapping table for Movie and Actor
 */

@Data
@Entity(name= "TM_MOVIE_ACTOR")
public class MovieActor {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cntNo;

    private String docid;            // 영화코드
    private String actorId;          // 배우코드

    @ManyToOne
    @JoinColumn(name = "docid")
    private MovieVO movie;

    @ManyToOne
    @JoinColumn(name = "actor_id")
    private ActorVO actor;

}
