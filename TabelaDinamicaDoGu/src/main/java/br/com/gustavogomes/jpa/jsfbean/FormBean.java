package br.com.gustavogomes.jpa.jsfbean;


import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.gustavogomes.jpa.ejbbean.DespesasBean;

import br.com.senai.gustavogomes.model.Despesas;

@Named("form")   //criando o nome
@RequestScoped   //tempo de vida requisição , quando termina apaga o objeto

public class FormBean implements Serializable {
	
	@EJB  
	private DespesasBean despesasBean;

	@Inject
	private FacesContext context;   //fazem parte do ejb
	
	private UIComponent searchInputText;  //tambem faz parte do ejb
	
	private Integer tarefaId;
	
	private Despesas despesas;
	
	public void gravar(AjaxBehaviorEvent event) { //voce consegue fazer o refreshe em tal linha especifica e não o sistema inteiro	//quando chamar ele tambem grava com o GRAVAR
		if(despesas.getId()==null) {
			despesasBean.inserir(despesas);//
		}else {
			despesasBean.atualizar(despesas);
		}		
	}
	
	public void pesquisar(AjaxBehaviorEvent event) { 
		despesas = despesasBean.carregar(tarefaId);
		
		if(despesas == null) {
			context.addMessage(searchInputText.getClientId(context),
					new FacesMessage("Tarefa não encontrada"));
		}
		tarefaId = null;		
	}
	
	public void excluir(AjaxBehaviorEvent event) {
		despesasBean.excluir(despesas); //ele vai puxar a tarefa exluir ela e da um retorno sem informação
		despesas= null;
	}
	public Despesas getTarefa() {
		if(despesas==null) { 	//se ela não existir ele cria ela 
			despesas = new Despesas(); // nova tarefa 
		}
		return despesas;
	}

	public UIComponent getSearchInputText() {
		return searchInputText;
	}

	public void setSearchInputText(UIComponent searchInputText) {
		this.searchInputText = searchInputText;
	}

	public Integer getTarefaId() {
		return tarefaId;
	}

	public void setTarefaId(Integer tarefaId) {
		this.tarefaId = tarefaId;
	}
	
	
	
}
