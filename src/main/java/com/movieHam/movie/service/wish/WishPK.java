package com.movieHam.movie.service.wish;

import lombok.Data;

import java.io.Serializable;

@Data
public class WishPK implements Serializable {
    private Long userId;
    private Long movieId;
}
