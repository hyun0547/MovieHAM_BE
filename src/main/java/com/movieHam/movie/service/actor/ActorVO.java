package com.movieHam.movie.service.actor;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity(name = "TN_ACTOR")
public class ActorVO {

    @Id
    private String actorId;                // 배우코드

    private String actorNm;                // 배우명
    private String actorEnNm;             // 배우영문명
}
