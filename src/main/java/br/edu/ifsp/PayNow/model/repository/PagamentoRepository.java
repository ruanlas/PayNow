package br.edu.ifsp.PayNow.model.repository;

import br.edu.ifsp.PayNow.model.entity.Pagamento;
import br.edu.ifsp.PayNow.model.entity.Usuario;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;


public class PagamentoRepository {

	@Inject
	private EntityManager em;

	public void salvar(Pagamento me) {
		em.persist(me);
	}

	public Pagamento comId(long id) {
		return em.find(Pagamento.class, id);
	}

	public List<Pagamento> todas() {
		return em.createQuery("FROM " + Pagamento.class.getSimpleName(),
				Pagamento.class).getResultList();
	}

}