package com.movieHam.movie.repository;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.movieHam.movie.service.Movie;
import com.movieHam.movie.service.MovieSearch;

public class MovieCustomRepositoryImpl implements MovieCustomRepository{

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Movie> findList(MovieSearch movieSearch) {
        Query query = new Query();
        List<Criteria> criteriaList = new ArrayList<>();
        Criteria criteria = new Criteria();

        // Non null field check
        for(Field field : movieSearch.getClass().getDeclaredFields()){
            field.setAccessible(true);

            try {
                if(field.get(movieSearch) != null){
                    switch (field.getName()) {
                        case "title":
                            criteriaList.add(Criteria.where("title")
                                .regex(".*"+movieSearch.getTitle()+".*", "i"));
                            break;
                        case "fromDate":
                            criteriaList.add(Criteria.where("releaseDate")
                                .gte(movieSearch.getFromDate()));
                            break;
                        case "toDate":
                            criteriaList.add(Criteria.where("releaseDate")
                                .lte(movieSearch.getToDate()));
                            break;
                        case "movieIdList":
                            criteriaList.add(Criteria.where("_id")
                                .in(movieSearch.getMovieIdList()));
                        default:
                            break;
                    }
                }
            } catch (IllegalArgumentException | IllegalAccessException e) {
                e.printStackTrace();
            }

        }

        criteria.andOperator(criteriaList.toArray(new Criteria[0]));
        query.addCriteria(criteria);
        
        return mongoTemplate.find(query, Movie.class);
    }
    
}
