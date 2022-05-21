package com.movieHam.movie.service.director;

import com.movieHam.movie.service.actor.ActorVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryDefinition(domainClass = DirectorVO.class, idClass = String.class)
public interface DirectorRepository extends JpaRepository<DirectorVO, String> {
    List<DirectorVO> findAll();
}
