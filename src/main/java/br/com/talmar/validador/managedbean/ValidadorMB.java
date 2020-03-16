package br.com.talmar.validador.managedbean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.talmar.validador.exceptions.ViolacaoException;
import br.com.talmar.validador.exceptions.ViolacoesException;
import br.com.talmar.validador.validacao.contato.ValidadorContato;
import br.com.talmar.validador.vo.ContatoVO;

@Named("validadorMB")
@ViewScoped
public class ValidadorMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1347751506591380493L;
	private ContatoVO contato;
	
	@Inject
	private ValidadorContato validador;
	
	@PostConstruct
	public void init(){
		contato = new ContatoVO();
	}

	public ContatoVO getContato() {
		return contato;
	}

	public void setContato(ContatoVO contato) {
		this.contato = contato;
	}

	public String salvar() {
		
		try {
			validador.validarContato(this.contato);
			
			FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Contato salvo com sucesso."));
			contato = new ContatoVO();
		} catch (ViolacoesException e){
			addViolacoes(e);
		}
		
		return null;
	}

	private void addViolacoes(ViolacoesException e) {
		
		for (ViolacaoException v : e.getViolacoes()){
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, v.getMensagem(), null));
		}
		
	}
}
