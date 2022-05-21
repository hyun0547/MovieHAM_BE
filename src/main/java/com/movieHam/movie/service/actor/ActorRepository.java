package com.movieHam.movie.service.actor;

import com.movieHam.movie.service.actor.ActorVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryDefinition(domainClass = ActorVO.class, idClass = String.class)
public interface ActorRepository extends JpaRepository<ActorVO, String> {

    List<ActorVO> findAll();

    ActorVO save(ActorVO actor);
}
