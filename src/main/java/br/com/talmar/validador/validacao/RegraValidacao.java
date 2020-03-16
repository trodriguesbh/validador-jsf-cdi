package br.com.talmar.validador.validacao;

public interface RegraValidacao<D> {
	
	void validar(ContextoValidacao contexto, D dado);
}
