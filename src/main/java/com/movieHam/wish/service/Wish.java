package com.movieHam.wish.service;

import lombok.*;

import java.util.Date;

import javax.persistence.*;

@Getter
@Entity(name= "tn_wish")
public class Wish {

    @Id
    private Integer user_id;
    private Integer movie_id;
    private float rating;
    private Date reg_date;
    private Date mod_date;
    private String review;
    private boolean seen_yn;
    private boolean wish_status;
}
