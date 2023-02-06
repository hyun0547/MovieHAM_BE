USE movie_ham;
CREATE TABLE tn_movie
(
    movie_id BIGINT not null primary key,
    adult BOOLEAN DEFAULT FALSE,
    backdrop_path VARCHAR(512) NULL,
    original_language VARCHAR(512) NULL,
    original_title VARCHAR(512) NULL,
    overview TEXT NULL COMMENT '줄거리',
    popularity DOUBLE NULL COMMENT '인지도',
    poster_path VARCHAR(512) NULL COMMENT '포스터 이미지',
    release_date DATE NULL COMMENT '개봉일',
    title VARCHAR(512) NULL COMMENT '제목',
    vote_average DOUBLE NULL COMMENT '평점',
    vote_count INT NULL COMMENT '평가 수'
) charset=utf8 COLLATE=utf8_general_ci;

CREATE TABLE tn_genre
(
    genre_id INT NOT NULL PRIMARY KEY,
    name VARCHAR(128) NOT NULL
) charset=utf8 COLLATE=utf8_general_ci;
INSERT INTO tn_genre
values (27,'공포'), (10402,'음악'), (9648,'미스터리'), (10749,'로맨스'), (878,'SF'), (10770,'TV 영화'), (53,'스릴러'), (10752,'전쟁'), (37,'서부'), (28,'액션'), (12,'모험'), (16,'애니메이션'), (35,'코미디'), (80,'범죄'), (99,'다큐멘터리'), (18,'드라마'), (10751,'가족'), (14,'판타지'), (36,'역사');

CREATE TABLE tm_movie_genre
(
    movie_genre_id BIGINT NOT NULL PRIMARY KEY,
    movie_id BIGINT,
    genre_id INT,
    FOREIGN KEY (movie_id)
        REFERENCES tn_movie(movie_id) ON UPDATE CASCADE,
    FOREIGN KEY (genre_id)
        REFERENCES tn_genre(genre_id) ON UPDATE CASCADE
) charset=utf8 COLLATE=utf8_general_ci;

CREATE TABLE tn_people
(
    people_id  BIGINT  NOT NULL PRIMARY KEY COMMENT '배우코드',
    adult BOOLEAN NULL COMMENT '',
    gender TINYINT NULL COMMENT '성별',
    known_for_department VARCHAR(256) NULL COMMENT '',
    name VARCHAR(256) NULL COMMENT '이름',
    original_name VARCHAR(256) NULL COMMENT '이름',
    popularity VARCHAR(256) NULL COMMENT '인지도',
    profile_path VARCHAR(512) NULL COMMENT '프로필 이미지',
    job VARCHAR (256) NULL COMMENT '직업'
) charset=utf8 COLLATE=utf8_general_ci;


create table tm_movie_people
(
    movie_people_id BIGINT not null primary key,
    people_id BIGINT null,
    movie_id BIGINT null,
    order INT NULL COMMENT '출력순서',
    character VARCHAR(512) NULL COMMENT '극중 명',
    department VARCHAR(256) NULL COMMENT '담당',
    FOREIGN KEY (people_id)
        REFERENCES tn_people(people_id) ON UPDATE CASCADE,
    FOREIGN KEY (movie_id)
        REFERENCES tn_movie(movie_id) ON UPDATE CASCADE
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



