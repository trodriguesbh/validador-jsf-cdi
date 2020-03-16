package br.com.talmar.validador.validacao;

import javax.enterprise.inject.Instance;

import br.com.talmar.validador.exceptions.ViolacoesException;

@SuppressWarnings("rawtypes")
public class ExecutadorRegras<A extends Instance<? extends RegraValidacao>, D> {
	
	private ContextoValidacao contexto;
	
	public void validar(ContextoValidacao contexto, A regras, D dado) throws ViolacoesException{
			
		regras.forEach(r-> r.validar(contexto, dado));
		
		contexto.gerarCriticas();
	}

}
