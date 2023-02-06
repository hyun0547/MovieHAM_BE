package com.movieHam.movie.service.people;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.movieHam.movie.service.mapper.moviePeople.MoviePeople;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity(name = "TN_ACTOR")
public class People {

    @Id
    private String peopleId;                // 배우코드

    private String peopleNm;                // 배우명
    private String peopleEnNm;             // 배우영문명

    @OneToMany(mappedBy = "people")
    @JsonBackReference
    private List<MoviePeople> moviePeople;
}
