package br.edu.ifsp.PayNow.model.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.edu.ifsp.PayNow.model.entity.Mensalidade;

public class MensalidadesRepository {
	@Inject
	private EntityManager em;
	
	public void salvar(Mensalidade mensalidade) {
		em.persist(mensalidade);
	}
	
	public Mensalidade comId(long id) {
		return em.find(Mensalidade.class, id);
	}
	
	public List<Mensalidade> todas() {
		return em.createQuery("FROM "+Mensalidade.class.getSimpleName(),
				Mensalidade.class).getResultList();
	}
	
	public List<Mensalidade> vencimentoDoMesAno(Date date) {
		List<Mensalidade> mensalidadesMesAno = new ArrayList<Mensalidade>();
		for (Mensalidade mensalidade : this.todas()) {
			if(mensalidade.getDataVencimento().getMonth() == date.getMonth() && 
					mensalidade.getDataVencimento().getYear() == date.getYear()) {
				mensalidadesMesAno.add(mensalidade);
			}
		}
		return mensalidadesMesAno;
	}
	
	public List<Mensalidade> fachamentoDoMesAno(Date date) {
		List<Mensalidade> mensalidadesMesAno = new ArrayList<Mensalidade>();
		for (Mensalidade mensalidade : this.todas()) {
			if(mensalidade.getDataFechamento().getMonth() == date.getMonth() && 
					mensalidade.getDataFechamento().getYear() == date.getYear()) {
				mensalidadesMesAno.add(mensalidade);
			}
		}
		return mensalidadesMesAno;
	}
}
