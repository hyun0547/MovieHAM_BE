package com.movieHam.movie.service.director;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity(name = "TN_DIRECTOR")
public class DirectorVO {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cntNo;

    private String directorId;                 // 감독코드
    private String directorNm;                 // 감독명
    private String directorEnNm;              // 감독영문명

}
