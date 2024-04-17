package com.movieHam.user.controller;

import com.movieHam.user.service.UserService;

import util.mapper.ResultSet;

import com.movieHam.user.service.User;

import java.util.Map;

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
    public ResultSet getUser(
        @RequestParam Integer id) 
    {
        User user = userService.getUser(id);
        Map<String, Object> data = Map.of("data", user);
        ResultSet result = new ResultSet("Success", "Test", data);

        return result;
    }
    
    @PostMapping("/user/insert")
    public void insertUser(
        @RequestBody User user) 
    {
        userService.insertUser(user);
    }


}
