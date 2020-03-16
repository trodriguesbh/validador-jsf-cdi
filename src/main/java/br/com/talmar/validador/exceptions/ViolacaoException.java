package br.com.talmar.validador.exceptions;

public class ViolacaoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -453558353229394701L;
	
	private String mensaagem;
	
		
	public ViolacaoException(String mensagem){
		this.mensaagem = mensagem;
	}

	public String getMensagem() {
		return mensaagem;
	}
	
	

}
