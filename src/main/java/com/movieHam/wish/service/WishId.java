package com.movieHam.wish.service;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class WishId implements Serializable{
    
    private Integer userId;
    private Integer movieId;
}
