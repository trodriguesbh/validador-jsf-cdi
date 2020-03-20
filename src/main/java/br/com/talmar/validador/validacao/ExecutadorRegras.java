package br.com.talmar.validador.validacao;

import javax.enterprise.inject.Instance;

import br.com.talmar.validador.exceptions.ViolacoesException;

@SuppressWarnings("rawtypes")
public class ExecutadorRegras<R extends Instance<? extends RegraValidacao>, D> {
	
	private ContextoValidacao contexto;
	
	protected void validar(ContextoValidacao contexto, R regras, D dado) throws ViolacoesException{
			
		regras.forEach(r-> r.validar(contexto, dado));
		
		contexto.verificarCriticas();
	}

}
