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

    private String email;

    private String birthday;

    private String gender;

    private String age_range;

    private String nickname;

    private String thumbnail_image_url;

    private String is_default_image;

    @Enumerated(value = EnumType.STRING)
    private Role role;


    @Builder
    public UserVO(Long id, String email, String birthday, String gender, String age_range, String nickname, String thumbnail_image_url, String is_default_image, Role role){

        this.id = id;
        this.email = email;
        this.birthday = birthday;
        this.gender = gender;
        this.age_range = age_range;
        this.nickname = nickname;
        this.thumbnail_image_url = thumbnail_image_url;
        this.is_default_image = is_default_image;
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
