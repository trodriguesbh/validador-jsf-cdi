package br.com.talmar.validador.exceptions;

import java.util.List;

public class ViolacoesException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3840125768925852670L;
	
	private List<ViolacaoException> violacoes;
	
	public ViolacoesException(List<ViolacaoException> violacoes) {
		this.violacoes = violacoes;
	}

	public List<ViolacaoException> getViolacoes() {
		return violacoes;
	}
	
	
	
	

}
