package br.com.talmar.validador.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import br.com.talmar.validador.exceptions.ViolacoesException;
import br.com.talmar.validador.model.Contato;
import br.com.talmar.validador.repository.ContatoRepository;
import br.com.talmar.validador.validacao.contato.ValidadorContato;

@Stateless
public class ContatoService {
	
	@Inject
	private ContatoRepository repository;
	
	@Inject
	private ValidadorContato validador;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void salvar(Contato contato) throws ViolacoesException{
		validador.validarContato(contato);
		repository.save(contato);
		
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void excluir(Contato contato) throws ViolacoesException{
		validador.validarExcluir(contato);
		repository.delete(contato.getId());
	}
	
	public List<Contato> carregarTodos(){
		return repository.loadAll();
	}
	
	
}
