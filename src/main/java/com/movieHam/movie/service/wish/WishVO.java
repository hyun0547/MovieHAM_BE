package com.movieHam.movie.service.wish;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.util.Date;

@Data
@Entity(name= "tn_wish")
@IdClass(WishPK.class)
public class WishVO {

    @Id
    @Column(name="user_id")
    private Long userId;
    @Id
    @Column(name="movie_id")
    private Long movieId;

    private String rating;
    private Date regDate = new Date();
    private Date modDate;
    private String review;
    private String seenYn;
    private String wishStatus;

}