package com.movieHam.movie.service;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
public class MovieSearch {
    private String title;
    private Date fromDate;
    private Date toDate;
    private String peopleName;
    private String productionCountries;
    private String genre;
}
