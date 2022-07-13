package com.movieHam.user.service;

import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
public class OAuthAttributes {
    private Map<String, Object> attributes; // OAuth2 반환하는 유저 정보 Map
    private Long id;
    private String nameAttributeKey;
    private String nickname;
    private String email;
    private String picture;

    @Builder
    public OAuthAttributes(Map<String, Object> attributes, Long id, String nameAttributeKey, String name, String email, String picture) {
        this.id = id;
        this.attributes = attributes;
        this.nameAttributeKey = nameAttributeKey;
        this.nickname = name;
        this.email = email;
        this.picture = picture;
    }

    public static OAuthAttributes of(String registrationId, String userNameAttributeName, Map<String, Object> attributes){
        // 여기서 네이버와 카카오 등 구분 (ofNaver, ofKakao)

        return ofKakao(userNameAttributeName, attributes);
    }

    private static OAuthAttributes ofKakao(String userNameAttributeName, Map<String, Object> attributes) {
        return OAuthAttributes.builder()
                .id((Long) attributes.get("id"))
                .name((String) attributes.get("name"))
                .email((String) attributes.get("email"))
                .picture((String) attributes.get("picture"))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    public UserVO toEntity(){
        return User.builder()
                .id(id)
                .email(email)
                .nickname(nickname)
                .role(Role.USER) // 기본 권한 GUEST
                .build();
    }

}
