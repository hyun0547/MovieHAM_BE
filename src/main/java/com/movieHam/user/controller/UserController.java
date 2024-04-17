package com.movieHam.user.controller;

import com.movieHam.user.service.UserService;

import util.mapper.ResultSet;

import com.movieHam.user.service.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user")
    public ResultSet<User> getUser(
        @RequestParam Integer id) 
    {
        User user = userService.getUser(id);
        ResultSet<User> result = new ResultSet<User>("Success", "Test", user);

        return result;
    }
    
    @PostMapping("/user/insert")
    public void insertUser(
        @RequestBody User user) 
    {
        userService.insertUser(user);
    }


}
