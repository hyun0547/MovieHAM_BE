package com.movieHam.movie.service;

import lombok.*;

import java.util.Date;
import java.util.List;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@Document(collection = "movies")
public class Movie {

    @Id
    private Integer id;
    private boolean adult;
    private String backdropPath;
    private BelongsToCollection belongsToCollection;
    private int budget;
    private List<Genre> genres;
    private String homepage;
    private String imdbId;
    private String originalLanguage;
    private String originalTitle;
    private String overview;
    private double popularity;
    private String posterPath;
    private List<ProductionCompany> productionCompanies;
    private List<ProductionCountry> productionCountries;
    private Date releaseDate;
    private int revenue;
    private int runtime;
    private List<SpokenLanguage> spokenLanguages;
    private String status;
    private String tagline;
    private String title;
    private boolean video;
    private double voteAverage;
    private int voteCount;
    private List<Cast> cast;

    @Getter
    public static class BelongsToCollection {
        @Field(value = "id")
        private Integer id;
        private String name;
        private String posterPath;
        private String backdropPath;

    }

    @Getter
    public static class Genre {
        @Field(value = "id")
        private int id;
        private String name;

    }

    @Getter
    public static class ProductionCompany {
        @Field(value = "id")
        private int id;
        private String logoPath;
        private String name;
        private String originCountry;

    }

    @Getter
    public static class ProductionCountry {
        private String iso_3166_1;
        private String name;

    }

    @Getter
    public static class SpokenLanguage {
        private String englishName;
        private String iso_639_1;
        private String name;

    }

    @Getter
    public static class Cast {
        private boolean adult;
        private int gender;
        private int id;
        private String knownForDepartment;
        private String name;
        private String originalName;
        private double popularity;
        private String profilePath;
        private int castId;
        private String character;
        private String creditId;
        private int order;

    }
}

