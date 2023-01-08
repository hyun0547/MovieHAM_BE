package com.movieHam.movie.service.mapper.movieActor;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

}
