USE movieham;
CREATE TABLE TN_MOVIE
(
    DOCID              VARCHAR(100) NOT NULL COMMENT '영화코드' PRIMARY KEY,
    ACTOR_ID           VARCHAR(1000) NULL COMMENT '출연배우',
    DIRECTOR_ID        VARCHAR(50)  NULL COMMENT '감독',
    MOVIE_ID           VARCHAR(10)  NULL COMMENT 'ID',
    MOVIE_SEQ          VARCHAR(50)  NULL COMMENT 'SEQ',
    TITLE              VARCHAR(300) NULL COMMENT '제목',
    TITLE_ENG          VARCHAR(300) NULL COMMENT '영문제명',
    PROD_YEAR          VARCHAR(20)  NULL COMMENT '제작년도',
    NATION             VARCHAR(100) NULL COMMENT '국가',
    COMPANY            VARCHAR(100) NULL COMMENT '제작사',
    PLOT_KOR           TEXT         NULL COMMENT '줄거리',
    PLOT_ENG           TEXT         NULL COMMENT '줄거리(영문)',
    RUNTIME            VARCHAR(10)  NULL COMMENT '러닝타임',
    RATING             VARCHAR(30)  NULL COMMENT '관람등급',
    GENRE              VARCHAR(30)  NULL COMMENT '장르',
    TYPE               VARCHAR(20)  NULL COMMENT '유형구분',
    USE_CLASSIFICATION VARCHAR(20)  NULL COMMENT '용도구분',
    RATED_YN           CHAR         NULL COMMENT '심의여부',
    REP_RAT_DATE       VARCHAR(20)  NULL COMMENT '심의날짜',
    REP_RLS_DATE       VARCHAR(20)  NULL COMMENT '개봉일',
    KEYWORDS           VARCHAR(100) NULL COMMENT '키워드',
    POSTERS            TEXT         NULL COMMENT '포스터 URL',
    STLLS              TEXT         NULL COMMENT '스틸샷 URL',
    OPEN_THTR          VARCHAR(50)  NULL COMMENT '개봉극장',
    AWARDS1            VARCHAR(1000) NULL COMMENT '수상내역',
    AWARDS2            VARCHAR(1000) NULL COMMENT '수상내역',
    REG_DATE           VARCHAR(50)  NULL COMMENT '등록일',
    MOD_DATE           VARCHAR(50)  NULL COMMENT '수정일'
);

CREATE TABLE TN_ACTOR
(
    ACTOR_ID    VARCHAR(50)  NOT NULL PRIMARY KEY,
    ACTOR_NM    VARCHAR(100) NULL COMMENT '배우명',
    ACTOR_EN_NM VARCHAR(100) NULL COMMENT '배우영문명'
);

CREATE TABLE TN_DIRECTOR
(
    DIRECTOR_ID    VARCHAR(50)  NULL COMMENT '감독코드',
    DIRECTOR_NM    VARCHAR(100) NULL COMMENT '감독명',
    DIRECTOR_EN_NM VARCHAR(100) NULL COMMENT '감독영문명'
);





CREATE TABLE USER
(
    ID    VARCHAR(50) NOT NULL COMMENT '',
    PW    VARCHAR(50) NOT NULL COMMENT '',
    NAME  VARCHAR(50) NULL COMMENT '',
    EMAIL VARCHAR(50) NULL COMMENT '',
);

CREATE TABLE USER_WISH_MOVIE
(
    USER_ID VARCHAR(100) NOT NULL COMMENT '',
    DOCID           VARCHAR(100) NOT NULL COMMENT '',
    REG_DATE           VARCHAR(100) NOT NULL COMMENT '',
    MOD_DATE VARCHAR(100) NULL COMMENT '';
);

CREATE TABLE USER_SEEN_MOVIE
(
    USER_ID  VARCHAR(100) NOT NULL COMMENT '',
    DOCID    VARCHAR(100) NOT NULL COMMENT '',
    RATING   VARCHAR(5)  NULL COMMENT '',
    REVIEW   TEXT NULL COMMENT '',
    REG_DATE VARCHAR(100) NOT NULL COMMENT '',
    MOD_DATE VARCHAR(100) NULL COMMENT ''
);