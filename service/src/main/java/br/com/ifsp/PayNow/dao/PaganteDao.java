package br.com.ifsp.PayNow.dao;

import br.com.ifsp.PayNow.entities.PaganteEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class PaganteDao {

    public PaganteEntity create(PaganteEntity paganteEntity) {
        EntityManagerFactory entityManagerFactory = new Persistence().createEntityManagerFactory("paynow");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(paganteEntity);
        entityManager.getTransaction().commit();

        return paganteEntity;
    }
}
