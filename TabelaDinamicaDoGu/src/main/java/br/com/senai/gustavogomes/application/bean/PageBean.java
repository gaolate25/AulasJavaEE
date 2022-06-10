package br.com.senai.gustavogomes.application.bean;




import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import br.com.senai.gustavogomes.model.Despesas;


@SuppressWarnings("serial") 
@Stateless 

public class PageBean implements Serializable{
	
	
	@PersistenceContext
	private EntityManager em;
	
	private List<Despesas> despesas = new ArrayList<>();
	
	String date;
	String desc;
	Double valor;
	Boolean back = false; 
	
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor1) {
		valor = valor1;
	}

	
	
	
	
	public String inserir(String data,String desc,Integer valor) {
		
		Despesas d = new Despesas(data,desc,valor); 
		d.setEdit(true);
		back =true;
		despesas.add(d);
		date = null;
		desc = null;
		valor= null;
		return null;
		
	}
	
	public String excluir(Despesas despesa) {
		despesas.remove(despesa);
		
		return null;
	}
	
	public String editar(Despesas despesa) {
		despesa.setEdit(true); 
		
		return null;
	}
	
	public String gravar (Despesas despesa) {
		despesa.setEdit(false);
		
		return null;
	}
	
	public List<Despesas> getDespesas() {
		return despesas;
	}

	public Boolean getBack() {
		return back;
	}

	public void setBack(Boolean back) {
		this.back = back;
	}

}
