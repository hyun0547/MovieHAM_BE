package com.movieHam.movie.service.wish;

import com.movieHam.movie.service.movie.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import util.StringHandler;
import util.com.CommonUtil;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class WishService {

    @Autowired
    WishRepository wishRepository;

}
