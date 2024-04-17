package com.movieHam.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    public User insertUser(User user){
        return userRepository.save(user);
    }

    public User getUser(Integer id){
        return userRepository.findById(id).get();
    }
}

