package br.com.senai.gustavogomes.application.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Named;

import br.com.senai.gustavogomes.model.Despesas;


@SuppressWarnings("serial")
@Named("tabela")
@SessionScoped // sessão com uma classe de entidadede do jsf 
public class TabelaBean implements Serializable {
	
	private List<Despesas> despesasList = new ArrayList<>(); // criando uma nova lista  com o Arraylist
	private ListDataModel<Despesas> despesas = new ListDataModel<>(despesasList); // colocando informaçoes na tabela e com o data model = modelo de datas 
	
	public String inserir() {           //criando novo objeto e colocando na lista 
		Despesas d = new Despesas();
		d.setEdit(true);
		despesasList.add(d);
		return null;
		}
	
	public String excluir(Despesas despesa) {    //excluindo objeto da lista 
		despesasList.remove(despesa);
		return null;
	}
	
	public String editar(Despesas despesa) {
		despesa.setEdit(true);
		return null;
	}
	
	public String gravar(Despesas despesa) {
		despesa.setEdit(false);
		return null;
	}
	public ListDataModel<Despesas> getDespesas(){
		return despesas;
	}
}
