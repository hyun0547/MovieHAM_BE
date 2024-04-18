package com.movieHam.wish.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WishServiceImpl implements WishService{

    @Autowired
    private WishRepository wishRepository;

    @Override
    public void insertWish(Wish wish) {
        wishRepository.save(wish);
    }

    @Override
    public Wish getWish(Integer userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getWish'");
    }

    @Override
    public List<Wish> getWishList(Integer userId){
        return wishRepository.findByWishIdUserId(userId);
    }

   
}
