package com.movieHam.user.controller;

import com.movieHam.user.service.SessionUser;
import com.movieHam.user.service.UserService;
import com.movieHam.user.service.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserProfileController {

    @Autowired
    UserService userService;

    @GetMapping(value="/user/profile", produces = "application/json; charset=UTF-8")
    public Map<String, Object> doLogin(HttpSession session, String code) {

        SessionUser sessionUser = (SessionUser) session.getAttribute("user");
        UserVO user = userService.view(sessionUser.getUniqueId());

        Map<String, Object> result = new HashMap<>(){{
            put("status", "success");
            put("user", user);
        }};

        return result;
    }


}
