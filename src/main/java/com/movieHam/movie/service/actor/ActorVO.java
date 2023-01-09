package com.movieHam.movie.service.actor;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.movieHam.movie.service.mapper.movieActor.MovieActor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity(name = "TN_ACTOR")
public class ActorVO {

    @Id
    private String actorId;                // 배우코드

    private String actorNm;                // 배우명
    private String actorEnNm;             // 배우영문명

    @OneToMany(mappedBy = "actor")
    private List<MovieActor> movieActor;
}
