package com.movieHam.movie.service.wish;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity(name= "tn_wish")
public class WishVO {

    @Id
    private String userId;
    private Integer movieId;
    private String rating;
    private String regDate;
    private String modDate;
    private String review;
    private String seenYn;

}