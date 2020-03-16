package br.com.talmar.validador.validacao.contato;

import javax.enterprise.context.RequestScoped;

import br.com.talmar.validador.validacao.ContextoValidacao;
import br.com.talmar.validador.vo.ContatoVO;

@RequestScoped
public class ValidarNomeContato implements ValidacaoContato {

	@Override
	public void validar(ContextoValidacao contexto, ContatoVO dado) {
		contexto.validar(null == dado.getNome() || "".equals(dado.getNome()),
				"Nome deve ser preenchido");
	}

}
