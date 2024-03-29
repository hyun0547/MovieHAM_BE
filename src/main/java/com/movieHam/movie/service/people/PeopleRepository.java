package com.movieHam.movie.service.people;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryDefinition(domainClass = People.class, idClass = String.class)
public interface PeopleRepository extends JpaRepository<People, String> {

    @Query(
            value = "select * from tn_people where name regexp '[A-Za-z]+$'",
            nativeQuery = true
    )
    List<People> findByNameContainsEn(Pageable pageable);

}
