package br.com.talmar.validador.validacao.contato;

import javax.enterprise.context.RequestScoped;

import br.com.talmar.validador.validacao.ContextoValidacao;
import br.com.talmar.validador.vo.ContatoVO;


@RequestScoped
public class ValidarEmailContato implements ValidacaoContato {

	@Override
	public void validar(ContextoValidacao contexto, ContatoVO dado) {
		contexto.validar(null == dado.getEmail() || "".equals(dado.getEmail()),
				"Email deve ser preenchido");
		
	}

}
