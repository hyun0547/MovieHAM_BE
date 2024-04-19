package com.movieHam.movie.repository;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.domain.Sort;


import com.movieHam.common.SearchKeyword;
import com.movieHam.movie.service.Movie;

public class MovieCustomRepositoryImpl implements MovieCustomRepository{

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Movie> findList(SearchKeyword searchKeyword) {
        Query query = new Query();
        List<Criteria> criteriaList = new ArrayList<>();
        Criteria criteria = new Criteria();

        // Non null field check
        for(Field field : searchKeyword.getClass().getDeclaredFields()){
            field.setAccessible(true);

            try {
                if(field.get(searchKeyword) != null){
                    switch (field.getName()) {
                        case "title":
                            criteriaList.add(Criteria.where("title")
                                .regex(".*"+searchKeyword.getTitle()+".*", "i"));
                            break;
                        case "fromDate":
                            criteriaList.add(Criteria.where("releaseDate")
                                .gte(searchKeyword.getFromDate()));
                            break;
                        case "toDate":
                            criteriaList.add(Criteria.where("releaseDate")
                                .lte(searchKeyword.getToDate()));
                            break;
                        case "movieIdList":
                            criteriaList.add(Criteria.where("_id")
                                .in(searchKeyword.getMovieIdList()));
                            break;
                        case "peopleName":
                            criteriaList.add(Criteria.where("cast.name")
                                .regex(".*"+searchKeyword.getPeopleName()+".*", "i"));
                            break;
                        case "productionCountries":
                            criteriaList.add(Criteria.where("productionCountries.iso_3166_1")
                                .is(searchKeyword.getProductionCountries()));
                            break;
                        case "genre":
                            criteriaList.add(Criteria.where("genres.name")
                                .is(searchKeyword.getGenre()));
                            break;
                        case "countPerPage":

                        break;
                                
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

        // 정렬
        Sort.Direction direction = Sort.Direction.DESC;
        Sort sort = Sort.by(direction, "releaseDate");
        query.with(sort);

        // 페이지당 카운트
        query.limit(searchKeyword.getCountPerPage());
        
        return mongoTemplate.find(query, Movie.class);
    }
    
}
