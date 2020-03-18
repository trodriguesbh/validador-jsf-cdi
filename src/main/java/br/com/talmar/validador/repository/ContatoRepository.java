package br.com.talmar.validador.repository;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.talmar.validador.model.Contato;

@RequestScoped
public class ContatoRepository {

	
	@PersistenceContext
	private EntityManager em;
	
	public void save(Contato contato){
		em.persist(contato);
	}
	
	public void delete(Contato contato){
		em.remove(contato);
	}
	
	public List<Contato> loadAll(){
		Query q =  em.createQuery("select c from Contato c");
		return q.getResultList();
	}
}
