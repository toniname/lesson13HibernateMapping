package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class PlanetCrudService {
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistenceUnit");

    public Planet createPlanet(Planet planet) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(planet);
        transaction.commit();
        entityManager.close();
        return planet;
    }

    
}
