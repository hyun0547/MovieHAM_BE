package com.movieHam.movie.service.people;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryDefinition(domainClass = People.class, idClass = String.class)
public interface PeopleRepository extends JpaRepository<People, String> {

    List<People> findAll();

    People save(People people);

    List<People> findByPeopleNmContains(String keyword);
}
