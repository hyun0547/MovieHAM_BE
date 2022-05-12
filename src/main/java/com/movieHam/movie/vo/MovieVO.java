package com.movieHam.movie.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity(name = "movie")
@Table(name = "TN_MOVIE")
public class MovieVO {

    @Id
    @Column(name = "DOCID")
    private String docid;            // 영화코드

    private String actorId;          // 출연배우
    private String directorId;       // 감독
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
}
