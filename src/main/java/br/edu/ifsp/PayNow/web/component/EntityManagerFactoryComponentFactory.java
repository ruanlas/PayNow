package br.edu.ifsp.PayNow.web.component;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped
public class EntityManagerFactoryComponentFactory {

	private final EntityManagerFactory emf =
			Persistence.createEntityManagerFactory("hsqldb-pu");

	@Produces
	public EntityManagerFactory obter() {
		return emf;
	}

}
