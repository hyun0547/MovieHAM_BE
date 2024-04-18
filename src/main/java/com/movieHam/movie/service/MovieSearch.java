package com.movieHam.movie.service;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter
public class MovieSearch {
    private String title;
    private List<Integer> movieIdList;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fromDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date toDate;
    
    private String peopleName;
    private String productionCountries;
    private String genre;
}
