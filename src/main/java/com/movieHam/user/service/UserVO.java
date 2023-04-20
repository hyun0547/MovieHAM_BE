package com.movieHam.user.service;

import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id", "email", "birthday", "gender", "age_range", "nickname"})
@Entity(name= "tn_user")
public class UserVO {

    @Id
    @Column(name = "user_id")
    private Long id;

    private String email;

    private String birthday;

    private String gender;

    private String age_range;

    private String nickname;

}


