package br.com.talmar.validador.service;

import java.util.List;

import javax.annotation.processing.SupportedAnnotationTypes;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.talmar.validador.exceptions.ViolacoesException;
import br.com.talmar.validador.model.Contato;
import br.com.talmar.validador.repository.ContatoRepository;
import br.com.talmar.validador.validacao.contato.ValidadorContato;
import br.com.talmar.validador.vo.ContatoVO;

@Stateless
public class ContatoService {

	
	@Inject
	private ContatoRepository repository;
	
	@Inject
	private ValidadorContato validador;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void salvar(ContatoVO contato) throws ViolacoesException{
		validador.validarContato(contato);
		Contato novoContato = createModel(contato);
		repository.save(novoContato);
		
	}
	
	public List<Contato> carregarTodos(){
		return repository.loadAll();
	}
	
	private Contato createModel(ContatoVO contato){
		Contato model = new Contato();
		model.setEmail(contato.getEmail());
		model.setNome(contato.getNome());
		
		return model;
	}
}
