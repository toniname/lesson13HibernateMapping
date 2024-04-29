package org.example;
//Опиши сутності Client та Planet. Пропиши Hibernate мапінги для цих сутностей (таблиці в БД client та planet відповідно).
//Напиши CRUD сервіси для обох сутностей - ClientCrudService та PlanetCrudService.
//Напиши тестовий код, який додаватиме/видалятиме записи за допомогою цих сервісів. Переконайсь, що всі CRUD операції працюють правильно.
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

    public List<Planet> getAllPlanets(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Planet> planets = entityManager.createQuery("SELECT p FROM Planet p", Planet.class).getResultList();
        entityManager.close();
        return planets;
    }


}
