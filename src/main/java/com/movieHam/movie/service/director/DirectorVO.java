package com.movieHam.movie.service.director;

import com.movieHam.movie.service.mapper.movieDirector.MovieDirector;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "TN_DIRECTOR")
public class DirectorVO {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cntNo;

    private String directorId;                 // 감독코드
    private String directorNm;                 // 감독명
    private String directorEnNm;              // 감독영문명

    @OneToMany(mappedBy = "director")
    private List<MovieDirector> movieDirector;
}
