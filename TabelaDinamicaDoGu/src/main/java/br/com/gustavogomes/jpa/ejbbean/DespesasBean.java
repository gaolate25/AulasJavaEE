package br.com.gustavogomes.jpa.ejbbean;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import br.com.senai.gustavogomes.model.Despesas;

@Stateless // ele disponibilizará uma funcionalidade de mudança de função, de dólar para real
public class DespesasBean {

	@PersistenceContext // persistindo no contexto
	private EntityManager em; ///ele que gerencia o banco de dados  e tambem ele chama jpa
	
	public void inserir(Despesas despesas) {
		em.persist(despesas);  // persistir em despesas
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

