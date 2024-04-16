package com.movieHam.user.controller;

import com.movieHam.user.service.UserService;
import com.movieHam.user.service.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value="/user/insert", produces = "application/json; charset=UTF-8")
    public void doLogin(@RequestBody User user) {
        userService.save(user);
    }


}
