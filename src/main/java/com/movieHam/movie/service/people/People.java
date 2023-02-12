package com.movieHam.movie.service.people;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.movieHam.movie.service.mapper.moviePeople.MoviePeople;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity(name = "tn_people")
public class People {

    @Id
    private Integer peopleId;
    private boolean adult;
    private Integer gender;
    private String knownForDepartment;
    private String name;
    private String originalName;
    private double popularity;
    private String profilePath;
    private String job;

    @OneToMany(mappedBy = "people")
    @JsonBackReference
    private List<MoviePeople> moviePeople;
}
