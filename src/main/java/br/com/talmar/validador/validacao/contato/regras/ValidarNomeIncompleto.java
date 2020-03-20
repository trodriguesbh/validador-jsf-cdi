package br.com.talmar.validador.validacao.contato.regras;

import javax.enterprise.context.RequestScoped;

import br.com.talmar.validador.model.Contato;
import br.com.talmar.validador.validacao.ContextoValidacao;
import br.com.talmar.validador.validacao.contato.ValidacaoContato;

@RequestScoped
public class ValidarNomeIncompleto implements ValidacaoContato {

	@Override
	public void validar(ContextoValidacao contexto, Contato dado) {
		String[] nomes = dado.getNome().split("\\W+");
		contexto.validar(nomes.length < 3,
				"Nome incompleto. Deve ser informado 3 nomes");
	}

}
