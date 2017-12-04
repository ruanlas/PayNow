package br.edu.ifsp.PayNow.model.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

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

	public Usuario buscaPorEmail(String email) {
		try {
			return (Usuario) em.createQuery("FROM " + Usuario.class.getSimpleName() + " where email like '%" + email + "%'").getSingleResult();

		} catch (NoResultException ex) {
			return null;
		}
	}

}
