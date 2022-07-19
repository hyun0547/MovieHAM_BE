package com.movieHam.user.service.oAuth;

import com.movieHam.user.service.Role;
import com.movieHam.user.service.UserVO;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
public class OAuthAttributes {
    private Map<String, Object> attributes; // OAuth2 반환하는 유저 정보 Map
    private Long id;
    private String nameAttributeKey;
    private String email;
    private String birthday;
    private String gender;
    private String age_range;
    private String nickname;
    private String thumbnail_image_url;
    private String is_default_image;

    @Builder
    public OAuthAttributes(Map<String, Object> attributes, String nameAttributeKey, Long id, String email, String birthday, String gender, String age_range, String nickname, String thumbnail_image_url, String is_default_image) {
        this.nameAttributeKey = nameAttributeKey;
        this.id = id;
        this.attributes = attributes;
        this.email = email;
        this.birthday = birthday;
        this.gender = gender;
        this.age_range = age_range;
        this.nickname = nickname;
        this.thumbnail_image_url = thumbnail_image_url;
        this.is_default_image = is_default_image;
    }

    public static OAuthAttributes of(String registrationId, String userNameAttributeName, Map<String, Object> attributes){
        // 여기서 네이버와 카카오 등 구분 (ofNaver, ofKakao)

        return ofKakao(userNameAttributeName, attributes);
    }

    private static OAuthAttributes ofKakao(String userNameAttributeName, Map<String, Object> attributes) {
        Map<String, Object> kakaoAccount = (Map<String, Object>) attributes.get("kakao_account");
        Map<String, Object> profile = (Map<String, Object>) kakaoAccount.get("profile");
        return OAuthAttributes.builder()
                .id((Long) attributes.get("id"))
                .email((String) kakaoAccount.get("email"))
                .birthday((String) kakaoAccount.get("birthday"))
                .gender((String) kakaoAccount.get("gender"))
                .age_range((String) kakaoAccount.get("age_range"))
                .nickname((String) profile.get("nickname"))
                .thumbnail_image_url((String) profile.get("thumbnail_image_url"))
                .is_default_image((Boolean) profile.get("is_default_image") == true ? "Y" : "N")
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    public UserVO toEntity(){
        return UserVO.builder()
                .id(id)
                .email(email)
                .birthday(birthday)
                .gender(gender)
                .age_range(age_range)
                .nickname(nickname)
                .thumbnail_image_url(thumbnail_image_url)
                .is_default_image(is_default_image)
                .role(Role.USER) // 기본 권한 GUEST
                .build();
    }

}
