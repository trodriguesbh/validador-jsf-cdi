package br.com.talmar.validador.validacao.contato;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

import br.com.talmar.validador.exceptions.ViolacoesException;
import br.com.talmar.validador.model.Contato;
import br.com.talmar.validador.validacao.ContextoValidacao;
import br.com.talmar.validador.validacao.ExecutadorRegras;
import br.com.talmar.validador.validacao.contato.regras.ValidacaoExcluirContato;

@RequestScoped
public class ValidadorContato extends ExecutadorRegras<Instance<ValidacaoContato>, Contato> {
	
	@Inject
	private Instance<ValidacaoContato> regras;
	
	@Inject @ValidacaoExcluirContato
	private Instance<ValidacaoContato> regrasExclusao;
	
	public void validarContato(Contato contato) throws ViolacoesException{
		ContextoValidacao contexto = new ContextoValidacao();
		this.validar(contexto, regras, contato);		
	}
	
	public void validarExcluir(Contato contato) throws ViolacoesException{
		ContextoValidacao contexto = new ContextoValidacao();
		this.validar(contexto, regrasExclusao, contato);		
	}
	
	
	
}
