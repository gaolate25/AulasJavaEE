package br.com.gustavogomes.jpa.ejbbean;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import br.com.senai.gustavogomes.model.Despesas;

@Stateless //
public class DespesasBean {

	@PersistenceContext //
	private EntityManager em; ///ele que gerencia o banco de dados  e tambem ele chama jpa
	
	public void inserir(Despesas despesas) {
		em.persist(despesas);
	}
	
	public void atualizar(Despesas despesas) {
		em.merge(despesas); // ele faz um update e atualiza
	}
	
	public void excluir(Despesas despesas) {
		despesas = carregar(despesas.getId());
		em.remove(despesas); // para remover alguma informação
	}
	
	public Despesas carregar(int id) {
		return em.find(Despesas.class, id); // ele primeiro pergunta a class e depois ele procura o id na tabela e faz a função de carregar 
	}
}

