package com.movieHam.movie.service;

import com.movieHam.movie.vo.MovieVO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    public EntityManager getEntityManager() {

        EntityManager entityManager;

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.movieHam");
        entityManager = emf.createEntityManager();

        return entityManager;
    }


    public void saveMovie(MovieVO movie) {

        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(movie);
        entityManager.getTransaction().commit();

        entityManager.close();
    }

    public MovieVO getMovie(String docid){

        EntityManager entityManager = getEntityManager();

        MovieVO movie = entityManager.find(MovieVO.class, docid);

        entityManager.close();

        return movie;
    }
}
