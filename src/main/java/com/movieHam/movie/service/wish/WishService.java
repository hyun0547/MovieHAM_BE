package com.movieHam.movie.service.wish;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WishService {

    @Autowired
    WishRepository wishRepository;

    public void save(WishVO wishVO) {
        wishRepository.save(wishVO);
    }
}
