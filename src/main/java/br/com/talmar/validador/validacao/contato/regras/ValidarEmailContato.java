package br.com.talmar.validador.validacao.contato.regras;

import javax.enterprise.context.RequestScoped;

import br.com.talmar.validador.model.Contato;
import br.com.talmar.validador.validacao.ContextoValidacao;
import br.com.talmar.validador.validacao.contato.ValidacaoContato;


@RequestScoped
public class ValidarEmailContato implements ValidacaoContato {

	@Override
	public void validar(ContextoValidacao contexto, Contato dado) {
		contexto.validar(null == dado.getEmail() || "".equals(dado.getEmail()),
				"Email deve ser preenchido");
		
	}

}
