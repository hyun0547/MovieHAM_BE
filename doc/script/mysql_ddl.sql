USE movie_ham;
CREATE TABLE tn_movie
(
    DOCID              VARCHAR(100) NOT NULL COMMENT '영화코드' PRIMARY KEY,
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
) charset=utf8 COLLATE=utf8_general_ci;

CREATE TABLE tn_actor
(
    ACTOR_ID    VARCHAR(50)  NOT NULL PRIMARY KEY COMMENT '배우코드',
    ACTOR_NM    VARCHAR(100) NULL COMMENT '배우명',
    ACTOR_EN_NM VARCHAR(100) NULL COMMENT '배우영문명'
) charset=utf8 COLLATE=utf8_general_ci;

CREATE TABLE tn_director
(
    DIRECTOR_ID    VARCHAR(50)  NOT NULL PRIMARY KEY COMMENT '감독코드',
    DIRECTOR_NM    VARCHAR(100) NULL COMMENT '감독명',
    DIRECTOR_EN_NM VARCHAR(100) NULL COMMENT '감독영문명'
) charset=utf8 COLLATE=utf8_general_ci;

CREATE TABLE tn_user
(
    user_id             bigint       not null primary key,
    age_range           varchar(255) null,
    birthday            varchar(255) null,
    email               varchar(255) null,
    gender              varchar(255) null,
    is_default_image    varchar(255) null,
    nickname            varchar(255) null,
    role                varchar(255) null,
    thumbnail_image_url varchar(255) null
) charset=utf8 COLLATE=utf8_general_ci;

CREATE TABLE tn_wish
(
    USER_ID         VARCHAR(100) NOT NULL COMMENT '',
    DOCID           VARCHAR(100) NOT NULL COMMENT '',
    RATING          VARCHAR(5)  NULL COMMENT '',
    REG_DATE        VARCHAR(100) NOT NULL COMMENT '',
    MOD_DATE        VARCHAR(100) NULL COMMENT '',
    REVIEW          TEXT NULL COMMENT '',
    SEEN_YN         CHAR(2) NOT NULL,
#     FOREIGN KEY (USER_ID)
#         REFERENCES tn_user(USER_ID) ON UPDATE CASCADE,
    FOREIGN KEY (DOCID)
        REFERENCES tn_movie(DOCID) ON UPDATE CASCADE
) charset=utf8 COLLATE=utf8_general_ci;

create table tm_movie_director
(
    movie_director_id varchar(255) not null primary key,
    director_id varchar(255)  null,
    docid       varchar(255) null,
    FOREIGN KEY (director_id)
        REFERENCES tn_director(director_id) ON UPDATE CASCADE,
    FOREIGN KEY (docid)
        REFERENCES tn_movie(DOCID) ON UPDATE CASCADE
) charset=utf8 COLLATE=utf8_general_ci;

create table tm_movie_actor
(
    movie_actor_id   varchar(255) not null primary key,
    actor_id varchar(50) null,
    docid    varchar(100) null,
    FOREIGN KEY (actor_id)
        REFERENCES tn_actor(actor_id) ON UPDATE CASCADE,
    FOREIGN KEY (docid)
        REFERENCES tn_movie(DOCID) ON UPDATE CASCADE
) charset=utf8 COLLATE=utf8_general_ci;




