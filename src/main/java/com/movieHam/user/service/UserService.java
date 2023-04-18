package com.movieHam.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserVO save(UserVO user){
        return userRepository.save(user);
    }

    public UserVO view(Long userId){
        return userRepository.findById(userId).get();
    }
}

