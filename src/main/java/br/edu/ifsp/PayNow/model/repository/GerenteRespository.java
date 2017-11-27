package br.edu.ifsp.PayNow.model.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.edu.ifsp.PayNow.model.entity.Gerente;

public class GerenteRespository {
	@Inject
	private EntityManager em;
	
	public void salvar(Gerente gerente) {
		em.persist(gerente);
	}
	public void alterar(Gerente gerente) {
		em.persist(gerente);
	}
	public Gerente comId(long id) {
		return em.find(Gerente.class, id);
	}
	public List<Gerente> todos() {
		return em.createQuery("FROM " + Gerente.class.getSimpleName(),
				Gerente.class).getResultList();
	}
}
