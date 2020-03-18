package br.com.talmar.validador.exceptions;

public class Violacao {

	/**
	 * 
	 */
	private static final long serialVersionUID = -453558353229394701L;
	
	private String mensaagem;
	
		
	public Violacao(String mensagem){
		this.mensaagem = mensagem;
	}

	public String getMensagem() {
		return mensaagem;
	}
	
	

}
