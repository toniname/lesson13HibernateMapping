package org.example;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Створення налаштувань для persistence unit
        Map<String, String> properties = new HashMap<>();
        properties.put("javax.persistence.jdbc.url", "jdbc:postgresql://localhost:32768/Lesson12Hibernate");
        properties.put("javax.persistence.jdbc.user", "postgres");
        properties.put("javax.persistence.jdbc.password", "zxc987mnb");
        properties.put("javax.persistence.jdbc.driver", "org.postgresql.Driver");
        properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        properties.put("hibernate.show_sql", "true");

        // Створення об'єкта EntityManagerFactory
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistenceUnit", properties);

        // Отримання об'єкта EntityManager
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // Початок транзакції
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        // Виконання операцій з базою даних

        // Збереження об'єкта в базу даних
        // entityManager.persist(entity);

        // Виконання запитів до бази даних
        // Query query = entityManager.createQuery("SELECT e FROM EntityName e WHERE e.property = :value");
        // query.setParameter("value", someValue);
        // List<EntityName> resultList = query.getResultList();

        // Завершення транзакції
        transaction.commit();

        // Закриття EntityManager
        entityManager.close();

        // Закриття EntityManagerFactory
        entityManagerFactory.close();
    }
}