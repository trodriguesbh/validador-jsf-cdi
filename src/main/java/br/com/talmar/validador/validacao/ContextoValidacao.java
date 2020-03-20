package br.com.talmar.validador.validacao;

import java.util.ArrayList;
import java.util.List;

import br.com.talmar.validador.exceptions.Violacao;
import br.com.talmar.validador.exceptions.ViolacoesException;

public class ContextoValidacao {

	private List<Violacao> violacoes;

	public ContextoValidacao() {
		this.violacoes = new ArrayList<>();
	}

	public void validar(boolean condicao, String mensagem) {
		if (condicao) {
			violacoes.add(new Violacao(mensagem));
		}
	}

	public void verificarCriticas() throws ViolacoesException {
		if (!violacoes.isEmpty()) {
			throw new ViolacoesException(violacoes);
		}
	}
}
