package br.com.rafaelcosta.application.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.rafaelcosta.application.model.Cliente;


@Stateless //eele fica seguindo até parar de funcionar e quando parar de funcionar ele acaba saindo de perto
public class ClienteBean {

	@PersistenceContext
	private EntityManager em; //ela que faz a ligação com o banco de dados 
	
	public List<Cliente> listar() {
		return em.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList(); 
	}
}
