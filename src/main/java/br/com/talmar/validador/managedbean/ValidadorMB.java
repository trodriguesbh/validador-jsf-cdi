package br.com.talmar.validador.managedbean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.talmar.validador.exceptions.Violacao;
import br.com.talmar.validador.exceptions.ViolacoesException;
import br.com.talmar.validador.model.Contato;
import br.com.talmar.validador.service.ContatoService;

@Named("validadorMB")
@ViewScoped
public class ValidadorMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1347751506591380493L;
	private Contato contato;

	@Inject
	private ContatoService service;

	private List<Contato> contatos;

	@PostConstruct
	public void init() {
		contato = new Contato();
		contatos = service.carregarTodos();
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public String salvar() {

		try {
			service.salvar(contato);

			FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Contato salvo com sucesso."));
			contato = new Contato();
			contatos = service.carregarTodos();
		} catch (ViolacoesException e) {
			addViolacoes(e);
		}

		return null;
	}

	public void actionExcluir(Contato contato) {
		try {
			service.excluir(contato);

			FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Contato excluído com sucesso."));
			contatos = service.carregarTodos();
		} catch (ViolacoesException e) {
			addViolacoes(e);
		}

	}

	private void addViolacoes(ViolacoesException e) {

		for (Violacao v : e.getViolacoes()) {
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, v.getMensagem(), null));
		}

	}

	public List<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}

}
