package com.movieHam.user.service;

import lombok.*;

import javax.persistence.*;

@Getter
@Entity(name= "tn_user")
public class User {

    @Id
    @Column(name = "user_id")
    private Long id;

    private String email;

    private String birthday;

    private String gender;

    private String age_range;

    private String nickname;

}


