package com.movieHam.movie.vo;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "actor")
@Table(name = "TN_ACTOR")
public class ActorVO {

    @Id
    @Column(name = "ACTOR_ID")
    private String ACTOR_ID;                // 배우코드

    private String ACTOR_NM;                // 배우명
    private String ACTOR_EN_NM;             // 배우영문명
    private String REG_DATE;                // 등록일
    private String MOD_DATE;                // 수정일
}
