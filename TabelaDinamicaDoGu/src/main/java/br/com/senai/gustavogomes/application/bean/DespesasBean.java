package br.com.senai.gustavogomes.application.bean;

import javax.persistence.EntityManager;

import br.com.senai.gustavogomes.model.Despesas;

public class DespesasBean {
	private EntityManager em; //entidade para LOCALIZAR E CHAMAR A FUNÇÃO
	
	public void inserir (Despesas despesas) {
		em.persist(despesas);
	}
	
	public void atualizar (Despesas despesas) {
		em.merge(despesas);
	}
	
	public void  excluir (Despesas despesas) {
		despesas = carregar(despesas.getId());
		em.persist(despesas);
	}
	
	public Despesas carregar (int id) {
		return em.find(Despesas.class, id);
	}
	
	
}
