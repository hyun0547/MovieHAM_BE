package com.movieHam.wish.service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface WishRepository extends JpaRepository<Wish, WishId> {
    Optional<Wish> findById(WishId wishId);
    List<Wish> findByWishIdUserId(Integer userId);
}
