package br.edu.ifsp.PayNow.model.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import br.edu.ifsp.PayNow.model.entity.Pagador;


public class PagadorRepository {

	@Inject
	private EntityManager em;

	public void salvar(Pagador me) {
		em.persist(me);
	}

	public Pagador comId(long id) {
		return em.find(Pagador.class, id);
	}

	public List<Pagador> todas() {
		return em.createQuery("FROM " + Pagador.class.getSimpleName(),
				Pagador.class).getResultList();
	}

}
