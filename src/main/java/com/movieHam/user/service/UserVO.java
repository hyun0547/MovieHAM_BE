package com.movieHam.user.service;

import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id", "oAuth2Id", "email", "nickname", "introduction", "role"})
@Entity(name= "tn_user")
public class UserVO {

    @Id
    @Column(name = "user_id")
    private Long id;

    private String oAuth2Id;

    private String email;

    private String nickname;

    private String profileImageUrl;

    private String introduction;

    @Enumerated(value = EnumType.STRING)
    private Role role;


    @Builder
    public UserVO(Long id, String email, String nickname, Role role){

        this.id = id;
        this.email = email;
        this.nickname = nickname;
        this.role = role;
    }

    public String getRoleKey() {
        return role.getKey();
    }

    public Object update(String nickname, String email) {
        this.nickname = nickname;
        this.email = email;
        return this;
    }
}
