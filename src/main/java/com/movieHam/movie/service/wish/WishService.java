package com.movieHam.movie.service.wish;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WishService {

    @Autowired
    WishRepository wishRepository;

    public void save(WishVO wishVO) {
        wishRepository.save(wishVO);
    }

    public Optional<WishVO> findById(WishVO wishVO){
        WishPK wishPk = new WishPK();
        wishPk.setUserId(wishVO.getUserId());
        wishPk.setMovieId(wishVO.getMovieId());
        return wishRepository.findById(wishPk);
    }
}
