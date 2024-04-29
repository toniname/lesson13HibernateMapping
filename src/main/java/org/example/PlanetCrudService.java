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

    public List<Planet> getAllPlanets() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Planet> planets = entityManager.createQuery("SELECT p FROM Planet p", Planet.class).getResultList();
        entityManager.close();
        return planets;
    }

    public Planet getPlanetById(String id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Planet planet = entityManager.find(Planet.class, id);
        entityManager.close();
        return planet;
    }

    public void deletePlanetById(String id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Planet planet = entityManager.find(Planet.class, id);
        if (planet != null) {
            entityManager.remove(planet);
        }
        transaction.commit();
        entityManager.close();
    }

}
