package com.movieHam.wish.service;

import lombok.*;

import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter
@Entity(name= "tn_wish")
public class Wish {

    @EmbeddedId
    private WishId wishId;

    private float rating;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date regDate;
    private Date modDate;
    private String review;
    private boolean seenYn;
    private boolean wishYn;

    public void setWishId(Integer userId, Integer movieId){
        wishId.setUserId(userId);
        wishId.setMovieId(movieId);
    }

    public Integer getUserId(){
        return this.wishId.getUserId();
    }

    public Integer getMovieId(){
        return this.wishId.getMovieId();
    }
}
