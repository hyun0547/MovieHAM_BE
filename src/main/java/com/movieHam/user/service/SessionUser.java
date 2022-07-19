package com.movieHam.user.service;

import lombok.Getter;

import java.io.Serializable;

/**
 * 직렬화 기능을 가진 User클래스
 */
@Getter
public class SessionUser implements Serializable {

    private String nickname;
    private String email;
    private Long uniqueId;


    public SessionUser(UserVO user){
        this.uniqueId = user.getId();
        this.nickname = user.getNickname();
        this.email = user.getEmail();
    }
}
