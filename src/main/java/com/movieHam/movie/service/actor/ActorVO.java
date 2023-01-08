package com.movieHam.movie.service.actor;

import com.movieHam.movie.service.mapper.movieActor.MovieActor;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "TN_ACTOR")
public class ActorVO {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cntNo;

    private String actorId;                // 배우코드
    private String actorNm;                // 배우명
    private String actorEnNm;             // 배우영문명

    @OneToMany(mappedBy = "actor")
    private List<MovieActor> movieActor;
}
