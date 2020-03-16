package br.com.talmar.validador.validacao.contato;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

import br.com.talmar.validador.exceptions.ViolacoesException;
import br.com.talmar.validador.validacao.ContextoValidacao;
import br.com.talmar.validador.validacao.ExecutadorRegras;
import br.com.talmar.validador.vo.ContatoVO;

@RequestScoped
public class ValidadorContato extends ExecutadorRegras<Instance<ValidacaoContato>, ContatoVO> {
	
	@Inject
	private Instance<ValidacaoContato> regras;
	
	public void validarContato(ContatoVO contato) throws ViolacoesException{
		ContextoValidacao contexto = new ContextoValidacao();
		this.validar(contexto, regras, contato);		
	}
	
	
	
}
