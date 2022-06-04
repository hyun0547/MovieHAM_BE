package com.movieHam.user.controller;

import com.movieHam.externalApi.kakao.OAuth;
import com.movieHam.user.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import util.mapper.ResultSet;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@RestController
public class UserProfileController {

    OAuth kakaoOAuth;
    UserService userService;


    @RequestMapping("/user/doLogin")
    public String doLogin(HttpSession session, String code) {

        // 1번 인증코드 요청 전달
        String accessToken = kakaoOAuth.getAccessToken(code);
        // 2번 인증코드로 토큰 전달
        HashMap<String, Object> userInfo = kakaoOAuth.getUserInfo(accessToken);


        String userEmail = (String) userInfo.get("email");
        String userNickname = (String) userInfo.get("nickname");

//        ResultSet<User> joinRd = userService.doJoin("kakao", userEmail, userNickname);
//        Member loginedMember = joinRd.getData();

        if(userInfo.size() > 0) {
            session.setAttribute("accessToken", accessToken);
//            session.setAttribute("loginedMember", loginedMember);
        }

        return "/usr/home/main";
    }


}
