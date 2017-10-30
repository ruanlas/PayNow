package br.edu.ifsp.PayNow.model.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import br.edu.ifsp.PayNow.model.entity.Usuario;


public class UsuarioRepository {

	@Inject
	private EntityManager em;

	public void salvar(Usuario me) {
		em.persist(me);
	}

	public Usuario comId(long id) {
		return em.find(Usuario.class, id);
	}

	public List<Usuario> todas() {
		return em.createQuery("FROM " + Usuario.class.getSimpleName(),
				Usuario.class).getResultList();
	}

}
