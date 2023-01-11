package com.movieHam.movie.service.movie;

import com.movieHam.movie.service.actor.Actor;
import com.movieHam.movie.service.director.Director;
import com.movieHam.movie.service.mapper.movieActor.MovieActor;
import com.movieHam.movie.service.mapper.movieDirector.MovieDirector;
import lombok.Getter;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Getter
public class MovieDTO {

    public MovieDTO (Movie movie){
        this.docid = movie.getDocid();
        this.movieId = movie.getMovieId();
        this.movieSeq = movie.getMovieSeq();
        this.title = movie.getTitle();
        this.titleEng = movie.getTitleEng();
        this.prodYear = movie.getProdYear();
        this.nation = movie.getNation();
        this.company = movie.getCompany();
        this.plotKor = movie.getPlotKor();
        this.plotEng = movie.getPlotEng();
        this.runtime = movie.getRuntime();
        this.rating = movie.getRating();
        this.genre = movie.getGenre();
        this.type = movie.getType();
        this.useClassification = movie.getUseClassification();
        this.ratedYn = movie.getRatedYn();
        this.repRatDate = movie.getRepRatDate();
        this.repRlsDate = movie.getRepRlsDate();
        this.keywords = movie.getKeywords();
        this.posters = movie.getPosters();
        this.stlls = movie.getStlls();
        this.openThtr = movie.getOpenThtr();
        this.awards1 = movie.getAwards1();
        this.awards2 = movie.getAwards2();
        this.regDate = movie.getRegDate();
        this.modDate = movie.getModDate();

        actorList = new ArrayList<>();
        for(MovieActor movieActor : movie.getMovieActor()){
            actorList.add(movieActor.getActor());
        }

        directorList = new ArrayList<>();
        for(MovieDirector movieDirector : movie.getMovieDirector()){
            directorList.add(movieDirector.getDirector());
        }
    }

    @Id
    private String docid;            // 영화코드

    private String movieId;          // ID
    private String movieSeq;         // SEQ
    private String title;            // 제목
    private String titleEng;         // 영문제명
    private String prodYear;         // 제작년도
    private String nation;           // 국가
    private String company;          // 제작사
    private String plotKor;          // 줄거리
    private String plotEng;          // 줄거리(영문)
    private String runtime;          // 러닝타임
    private String rating;           // 관람등급
    private String genre;            // 장르
    private String type;             // 유형구분
    private String useClassification;      // 용도구분
    private String ratedYn;          // 심의여부
    private String repRatDate;       // 심의날짜
    private String repRlsDate;       // 개봉일
    private String keywords;         // 키워드
    private String posters;          // 포스터URL
    private String stlls;            // 스틸샷URL
    private String openThtr;         // 개봉극장
    private String awards1;          // 수상내역1
    private String awards2;          // 수상내역2
    private String regDate;          // 등록일
    private String modDate;          // 수정일

    List<Actor> actorList;
    List<Director> directorList;

    @Override
    public int hashCode() {
        return docid.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof MovieDTO)) {
            return false;
        }

        MovieDTO movie = (MovieDTO)obj;

        return docid.equals(movie.docid);

    }
}
