package br.com.rafaelcosta.jpa.jsfbean;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.rafaelcosta.jpa.ejbbean.TarefaBean;
import br.com.rafaelcosta.jpa.model.Tarefa;

@Named("form")   //criando o nome
@RequestScoped   //tempo de vida requisição , quando termina apaga o objeto

public class FormBean implements Serializable {
	
	@EJB  
	private TarefaBean tarefaBean;

	@Inject
	private FacesContext context;   //fazem parte do ejb
	
	private UIComponent searchInputText;  //tambem faz parte do ejb
	
	private Integer tarefaId;
	
	private Tarefa tarefa;
	
	public void gravar(AjaxBehaviorEvent event) { //voce consegue fazer o refreshe em tal linha especifica e não o sistema inteiro	//quando chamar ele tambem grava com o GRAVAR
		if(tarefa.getId()==null) {
			tarefaBean.inserir(tarefa);//
		}else {
			tarefaBean.atualizar(tarefa);
		}		
	}
	
	public void pesquisar(AjaxBehaviorEvent event) { 
		tarefa = tarefaBean.carregar(tarefaId);
		
		if(tarefa == null) {
			context.addMessage(searchInputText.getClientId(context),
					new FacesMessage("Tarefa não encontrada"));
		}
		tarefaId = null;		
	}
	
	public void excluir(AjaxBehaviorEvent event) {
		tarefaBean.excluir(tarefa); //ele vai puxar a tarefa exluir ela e da um retorno sem informação
		tarefa = null;
	}
	public Tarefa getTarefa() {
		if(tarefa==null) { 	//se ela não existir ele cria ela 
			tarefa = new Tarefa(); // nova tarefa 
		}
		return tarefa;
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
