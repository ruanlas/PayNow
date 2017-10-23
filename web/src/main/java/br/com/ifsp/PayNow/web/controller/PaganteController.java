package br.com.ifsp.PayNow.web.controller;

import br.com.caelum.vraptor.*;
import br.com.ifsp.PayNow.model.entity.Pagante;
import br.com.ifsp.PayNow.web.component.EntityManagerComponentFactory;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import static java.util.Arrays.asList;

@Resource
public class PaganteController {

    @Inject
    private EntityManagerComponentFactory entityManagerFactoryComponent;

    @Inject
    private Result result;

    public void lista() {
        System.out.println("Teste");
        EntityManager entityManager = entityManagerFactoryComponent.getInstance();
        entityManager.getTransaction().begin();
        result.include("pagantes", asList(entityManager.createQuery("select p from PaganteEntity p").getResultList()));
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void adiciona() {

    }
    
    public void salva(Pagante pagante) {
        EntityManager entityManager = entityManagerFactoryComponent.getInstance();
        entityManager.getTransaction().begin();
        entityManager.persist(pagante);
        entityManager.getTransaction().commit();
        result.redirectTo(PaganteController.class).resumo(pagante);
    }

    public void resumo(Pagante pagante) {
        result.include("resumo", pagante);
    }

    public String index() {
        return "ok";
    }
}
