package br.com.rafaelcosta.jpa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity ///ele fala que � uma entidade que vai ser gravada no banco de dados
public class Tarefa {

	@Id  // ele serve como id de entidade para localizar alguma informa��o
	@GeneratedValue // ele faz gera��o automatica 
	private Integer id;  //integer serve para n�o receber null
	
	private String descricao;
	
	private Integer prioridade;
	
	private Boolean concluida;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getConcluida() {
		return concluida;
	}

	public void setConcluida(Boolean concluida) {
		this.concluida = concluida;
	}

	public Integer getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(Integer prioridade) {
		this.prioridade = prioridade;
	}	
	
	
	
}
