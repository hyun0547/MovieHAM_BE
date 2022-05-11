package com.movieHam.actor.service;

import com.movieHam.actor.vo.ActorVO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.stereotype.Service;

@Service
public class ActorService {

//    @PersistenceContext(unitName = "com.movieHam")
//    EntityManager entityManager2;

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

        ActorVO actor = entityManager.find(ActorVO.class, actorId);

        entityManager.close();

        return actor;
    }


}
