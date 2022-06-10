package br.com.rafaelcosta.jpa.ejbbean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.rafaelcosta.jpa.model.Tarefa;

@Stateless // é um protocolo de comunicação que considera cada requisição como uma transação independente que não está relacionada
public class TarefaBean {

	@PersistenceContext // contexto de persistencia 
	private EntityManager em; ///ele que gerencia o banco de dados  e tambem ele chama jpa
	
	public void inserir(Tarefa tarefa) {
		em.persist(tarefa);
	}
	
	public void atualizar(Tarefa tarefa) {
		em.merge(tarefa); // ele faz um update e atualiza
	}
	
	public void excluir(Tarefa tarefa) {
		tarefa = carregar(tarefa.getId());
		em.remove(tarefa); // para remover alguma informação
	}
	
	public Tarefa carregar(int id) {
		return em.find(Tarefa.class, id); // ele primeiro pergunta a class e depois ele procura o id na tabela e faz a função de carregar 
	}
}
