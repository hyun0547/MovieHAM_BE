package com.movieHam.movie.service.genre;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.movieHam.movie.service.mapper.moviePeople.MovieGenre;
import com.movieHam.movie.service.mapper.moviePeople.MoviePeople;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity(name= "tn_genre")
public class Genre {

    @Id
    private Integer genreId;                // 장르아이디

    private String genreNm;                // 장르명

    @OneToMany(mappedBy = "genre")
    @JsonBackReference
    private List<MovieGenre> movieGenre;
}
