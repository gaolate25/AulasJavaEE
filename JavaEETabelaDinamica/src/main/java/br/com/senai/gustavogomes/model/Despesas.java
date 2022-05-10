package br.com.senai.gustavogomes.model;

import java.sql.Date;

public class Despesas {
	
	private String data;
	private String descricao;
	private Double valor;
	private boolean edit;
	
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
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public boolean isEdit() {
		return edit;
	}
	public void setEdit(boolean edit) {
		this.edit = edit;
	}
	
	

}
