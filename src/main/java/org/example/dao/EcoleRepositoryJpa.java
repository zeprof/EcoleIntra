package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import org.example.modele.Prof;

import java.util.Optional;

public class EcoleRepositoryJpa {
    private final EntityManagerFactory emf;

    public EcoleRepositoryJpa(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public <T> T save(T t) {
        final EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(t);

        entityManager.getTransaction().commit();
        entityManager.close();

        return t;
    }

    public Prof findProf(String profName) {
        final EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();

        TypedQuery<Prof> query =
                entityManager.createQuery("""
                        select p from Prof p 
                        left join fetch p.cours c
                        left join fetch c.etudiants
                        where lower(p.nomProf) = lower(:name)
                        """, Prof.class);
        query.setParameter("name", profName.trim());
        final Prof prof = query.getResultList().stream()
                .findFirst()
                .orElse(null);

        entityManager.getTransaction().commit();
        entityManager.close();

        return prof;

    }
}
