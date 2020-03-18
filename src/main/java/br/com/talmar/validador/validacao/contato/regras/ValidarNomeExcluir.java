package br.com.talmar.validador.validacao.contato.regras;

import javax.enterprise.context.RequestScoped;

import br.com.talmar.validador.model.Contato;
import br.com.talmar.validador.validacao.ContextoValidacao;
import br.com.talmar.validador.validacao.contato.ValidacaoContato;

@RequestScoped
@ValidacaoExcluirContato
public class ValidarNomeExcluir implements ValidacaoContato {

	@Override
	public void validar(ContextoValidacao contexto, Contato dado) {
		contexto.validar(dado.getNome().length() > 10, "Exclusão não permitida para nome >= 10");
		
	}

}
