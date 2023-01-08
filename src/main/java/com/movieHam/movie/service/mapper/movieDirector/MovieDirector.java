package com.movieHam.movie.service.mapper.movieDirector;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity(name= "TM_MOVIE_DIRECTOR")
public class MovieDirector {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cntNo;

    private String docid;            // 영화코드
    private String directorId;       // 배우코드

}
