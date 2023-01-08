package com.movieHam.movie.service.mapper.movieDirector;

import com.movieHam.movie.service.director.DirectorVO;
import com.movieHam.movie.service.movie.MovieVO;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name= "TM_MOVIE_DIRECTOR")
public class MovieDirector {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cntNo;

    private String docid;            // 영화코드
    private String directorId;       // 배우코드

    @ManyToOne
    @JoinColumn(name = "docid")
    private MovieVO movie;

    @ManyToOne
    @JoinColumn(name="director_id")
    private DirectorVO director;
}
