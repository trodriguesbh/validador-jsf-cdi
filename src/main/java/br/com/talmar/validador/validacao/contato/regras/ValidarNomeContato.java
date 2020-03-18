package br.com.talmar.validador.validacao.contato.regras;

import javax.enterprise.context.RequestScoped;

import br.com.talmar.validador.model.Contato;
import br.com.talmar.validador.validacao.ContextoValidacao;
import br.com.talmar.validador.validacao.contato.ValidacaoContato;

@RequestScoped
public class ValidarNomeContato implements ValidacaoContato {

	@Override
	public void validar(ContextoValidacao contexto, Contato dado) {
		contexto.validar(null == dado.getNome() || "".equals(dado.getNome()),
				"Nome deve ser preenchido");
	}

}
