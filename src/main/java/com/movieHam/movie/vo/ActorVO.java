package com.movieHam.movie.vo;

import lombok.Data;

@Data
public class ActorVO {

    private String ACTOR_ID;                // 배우코드
    private String ACTOR_NM;                // 배우명
    private String ACTOR_EN_NM;             // 배우영문명
    private String REG_DATE;                // 등록일
    private String MOD_DATE;                // 수정일

}
