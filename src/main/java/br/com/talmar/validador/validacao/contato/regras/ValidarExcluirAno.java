package br.com.talmar.validador.validacao.contato.regras;

import java.util.Calendar;

import javax.enterprise.context.RequestScoped;

import br.com.talmar.validador.model.Contato;
import br.com.talmar.validador.validacao.ContextoValidacao;
import br.com.talmar.validador.validacao.contato.ValidacaoContato;

@RequestScoped
@ValidacaoExcluirContato
public class ValidarExcluirAno implements ValidacaoContato {

	@Override
	public void validar(ContextoValidacao contexto, Contato dado) {
		Calendar c = Calendar.getInstance();
		c.setTime(dado.getDtNascimento());
		int ano = c.get(Calendar.YEAR);
		
		contexto.validar(ano < 2000, "Não pode excluir ano inferior a 2000");
		
	}

}
