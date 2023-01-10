package com.movieHam.movie.service.actor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryDefinition(domainClass = Actor.class, idClass = String.class)
public interface ActorRepository extends JpaRepository<Actor, String> {

    List<Actor> findAll();

    Actor save(Actor actor);

    List<Actor> findByActorNmContains(String keyword);
}
