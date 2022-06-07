package br.com.senai.gustavogomes.application.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Named;

import br.com.senai.gustavogomes.model.Despesas;



@SuppressWarnings("serial") //tira anuncios de advert�ncia
@Named("tabela")
@SessionScoped //tempo de vida da p�gina, o "session" mant�m os dados enquanto o navegador estiver aberto
public class TabelaBean implements Serializable{
	
	private List<Despesas> despesas = new ArrayList<>();
	//lista que trabalha com o jsf
	
	@EJB
	private DespesasBean despesaBean;
	private Integer despesaId;
	private Despesas despesa;
	String data1;
	String desc1;
	Integer Valor1;
	Boolean a = false; 
	
	
	public String getData1() {
		return data1;
	}

	public void setData1(String data1) {
		this.data1 = data1;
	}

	public String getDesc1() {
		return desc1;
	}

	public void setDesc1(String desc1) {
		this.desc1 = desc1;
	}

	public Integer getValor1() {
		return Valor1;
	}

	public void setValor1(Integer valor1) {
		Valor1 = valor1;
	}

	public void gravarBanco(Despesas d) {
		despesaBean.inserir(d);
		
	}
	
	
	public String inserir(String data,String desc,Integer Valor) {
		
		Despesas d = new Despesas(data,desc,Valor); //inst�ncia da listdatamodel
		d.setEdit(true);
		a =true;
		despesas.add(d);
		data1 = null;
		desc1 = null;
		Valor1= null;
		
		gravarBanco(d);
		
		return null;
		
	}
	
	public void excluirBanco(Despesas d) {
		despesaBean.excluir(d);
		
	}
	
	public String excluir(Despesas despesa) { 
		despesas.remove(despesa);
		excluirBanco(despesa);
		return null;
	}
	
	public void editarBanco(Despesas d) {
		despesaBean.atualizar(d);
		
	}
	
	public String editar(Despesas despesa) {
		despesa.setEdit(true); 
		
		editarBanco(despesa);
		
		return null;
	}
	
	
	public String gravar (Despesas despesa) {
		despesa.setEdit(false);
		if(despesa.getId() == null) {
			despesaBean.inserir(despesa);
		} else {
			despesaBean.atualizar(despesa);
		}
		
		return null;
	}
	
	public List<Despesas> getDespesas() {
		return despesas;
	}

	public Boolean getA() {
		return a;
	}

	public void setA(Boolean a) {
		this.a = a;
	}

}
