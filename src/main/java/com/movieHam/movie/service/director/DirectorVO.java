package com.movieHam.movie.service.director;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.movieHam.movie.service.mapper.movieDirector.MovieDirector;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity(name = "TN_DIRECTOR")
public class DirectorVO {

    @Id
    private String directorId;                 // 감독코드

    private String directorNm;                 // 감독명
    private String directorEnNm;              // 감독영문명

    @OneToMany(mappedBy = "director")
    private List<MovieDirector> movieDirector;
}
