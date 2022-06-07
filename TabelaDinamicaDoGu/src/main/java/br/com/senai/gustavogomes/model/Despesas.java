package br.com.senai.gustavogomes.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Despesas {
	@Id
	@GeneratedValue
	
	private Integer id;
	private String data;
	private String descricao;
	private Integer valor;
	private boolean edit;
	
	public Despesas(String data, String descricao , Integer valor) {
		super();
		this.data = data;
		this.descricao = descricao;
		this.valor = valor;
	}
	
	//colocando vazio para a entidade funcionar
	public Despesas() {
		
	}
		
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getData() {
		return data;
		
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Integer getValor() {
		return valor;
	}
	public void setValor(Integer valor) {
		this.valor = valor;
	}
	public boolean isEdit() {
		return edit;
	}
	public void setEdit(boolean edit) {
		this.edit = edit;
	}
	
	

}
