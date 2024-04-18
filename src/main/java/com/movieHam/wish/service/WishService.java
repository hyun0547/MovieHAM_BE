package com.movieHam.wish.service;

import java.util.List;

public interface WishService {
    public void insertWish(Wish wish);
    public Wish getWish(Integer userId);
    public List<Wish> getWishList(Integer userId);
}
