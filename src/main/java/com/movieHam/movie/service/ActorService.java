package com.movieHam.movie.service;

import com.movieHam.movie.vo.ActorVO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ActorService {

//    @PersistenceContext(unitName = "com.movieHam")

    public EntityManager getEntityManager() {

        EntityManager entityManager;

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.movieHam");
        entityManager = emf.createEntityManager();


        return entityManager;
    }


    public void saveActor(ActorVO actor) {

        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(actor);
        entityManager.getTransaction().commit();

        entityManager.close();
    }

    public ActorVO getActor(String actorId){

        EntityManager entityManager = getEntityManager();

        ActorVO actor = entityManager.find(ActorVO.class, "test");
        entityManager.close();

        return actor;
    }


}
