drop database movie_ham;
CREATE DATABASE movie_ham;
USE movie_ham;
CREATE TABLE tn_movie
(
    `movie_id` INT not null primary key,
    `adult` BOOLEAN DEFAULT FALSE,
    `backdrop_path` VARCHAR(512) NULL,
    `original_language` VARCHAR(512) NULL,
    `original_title` VARCHAR(512) NULL,
    `overview` TEXT NULL COMMENT '줄거리',
    `popularity` DOUBLE NULL COMMENT '인지도',
    `poster_path` VARCHAR(512) NULL COMMENT '포스터 이미지',
    `release_date` DATE NULL COMMENT '개봉일',
    `title` VARCHAR(512) NULL COMMENT '제목',
    `vote_average` DOUBLE NULL COMMENT '평점',
    `vote_count` INT NULL COMMENT '평가 수'
) charset=utf8 COLLATE=utf8_general_ci;

CREATE TABLE tn_genre
(
    `genre_id` INT NOT NULL PRIMARY KEY,
    `name` VARCHAR(128) NOT NULL
) charset=utf8 COLLATE=utf8_general_ci;
INSERT INTO tn_genre
values (27,'공포'), (10402,'음악'), (9648,'미스터리'), (10749,'로맨스'), (878,'SF'), (10770,'TV 영화'), (53,'스릴러'), (10752,'전쟁'), (37,'서부'), (28,'액션'), (12,'모험'), (16,'애니메이션'), (35,'코미디'), (80,'범죄'), (99,'다큐멘터리'), (18,'드라마'), (10751,'가족'), (14,'판타지'), (36,'역사');

CREATE TABLE tm_movie_genre
(
    `movie_genre_id` VARCHAR(128) NOT NULL PRIMARY KEY,
    `movie_id` INT,
    `genre_id` INT,
    FOREIGN KEY (movie_id)
        REFERENCES tn_movie(movie_id) ON UPDATE CASCADE,
    FOREIGN KEY (genre_id)
        REFERENCES tn_genre(genre_id) ON UPDATE CASCADE
) charset=utf8 COLLATE=utf8_general_ci;

CREATE TABLE tn_people
(
    `people_id`  INT  NOT NULL PRIMARY KEY COMMENT '배우코드',
    `adult` BOOLEAN NULL COMMENT '',
    `gender` TINYINT NULL COMMENT '성별',
    `known_for_department` VARCHAR(256) NULL COMMENT '',
    `name` VARCHAR(256) NULL COMMENT '이름',
    `original_name` VARCHAR(256) NULL COMMENT '이름',
    `popularity` DOUBLE NULL COMMENT '인지도',
    `profile_path` VARCHAR(512) NULL COMMENT '프로필 이미지',
    `job` VARCHAR (256) NULL COMMENT '직업'
) charset=utf8 COLLATE=utf8_general_ci;

create table tm_movie_people
(
    `movie_people_id` VARCHAR(128) not null primary key,
    `order` INT NULL COMMENT '출력순서',
    `character` VARCHAR(512) NULL COMMENT '극중 명',
    `department` VARCHAR(256) NULL COMMENT '담당',
    `movie_id` INT not null,
    `people_id` INT not null,
    FOREIGN KEY (people_id)
        REFERENCES tn_people(people_id) ON UPDATE CASCADE,
    FOREIGN KEY (movie_id)
        REFERENCES tn_movie(movie_id) ON UPDATE CASCADE
) charset=utf8 COLLATE=utf8_general_ci;

CREATE TABLE tn_user
(
    `user_id`             bigint       not null primary key,
    `age_range`           varchar(255) null,
    `birthday`            varchar(255) null,
    `email`               varchar(255) null,
    `gender`              varchar(255) null,
    `is_default_image`    varchar(255) null,
    `nickname`            varchar(255) null,
    `role`                varchar(255) null,
    `thumbnail_image_url` varchar(255) null
) charset=utf8 COLLATE=utf8_general_ci;

CREATE TABLE tn_wish
(
    `user_id`         bigint NOT NULL COMMENT '',
    `movie_id`        INT NOT NULL COMMENT '',
    `RATING`          VARCHAR(5)  NULL COMMENT '',
    `REG_DATE`        date NOT NULL COMMENT '',
    `MOD_DATE`        date NULL COMMENT '',
    `REVIEW`          TEXT NULL COMMENT '',
    `SEEN_YN`         CHAR(2) NOT NULL,
    `WISH_STATUS`     CHAR(2) NOT NULL,
    primary key (`user_id`, `movie_id`),
         FOREIGN KEY (USER_ID)
                 REFERENCES tn_user(USER_ID) ON UPDATE CASCADE,
    FOREIGN KEY (movie_id)
        REFERENCES tn_movie(movie_id) ON UPDATE CASCADE
) charset=utf8 COLLATE=utf8_general_ci;

create index idx_movie
    on tn_movie (movie_id);

create index idx_movie_genre
    on tm_movie_genre (movie_id, genre_id);

create index idx_genre
    on tn_genre (genre_id);

create index idx_movie_people
    on tm_movie_people (movie_id, people_id);

create index idx_people
    on tn_people (people_id);

create index idx_user
    on tn_user (user_id);

create index idx_wish_user
    on tn_wish (user_id, movie_id);


