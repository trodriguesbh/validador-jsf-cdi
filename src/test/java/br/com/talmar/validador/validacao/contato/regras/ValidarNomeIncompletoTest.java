package br.com.talmar.validador.validacao.contato.regras;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.com.talmar.validador.exceptions.ViolacoesException;
import br.com.talmar.validador.model.Contato;
import br.com.talmar.validador.validacao.ContextoValidacao;

public class ValidarNomeIncompletoTest {
	
	private ValidarNomeIncompleto validarNomeIncompleto;
	
	private ContextoValidacao contexto;
	
	@Before
	public void setUp() throws Exception {
		validarNomeIncompleto = new ValidarNomeIncompleto();
		contexto = new ContextoValidacao();
	}

	@Test
	public void testarNomeCompleto() throws ViolacoesException {
		Contato contato = new Contato();
		contato.setNome("Talmar R Gomes");
		
		validarNomeIncompleto.validar(contexto, contato);
		
		contexto.verificarCriticas();
		
		assertTrue(true);
		
	}
	
	@Test(expected=ViolacoesException.class)
	public void testarNomeIncompleto() throws ViolacoesException {
		Contato contato = new Contato();
		contato.setNome("Talmar Gomes");
		
		validarNomeIncompleto.validar(contexto, contato);
		
		contexto.verificarCriticas();
		
		
	}

}
