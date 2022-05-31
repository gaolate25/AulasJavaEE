package br.com.rafaelcosta.application.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.rafaelcosta.application.ejb.PedidoBean;
import br.com.rafaelcosta.application.model.Pedido;


@Named
@RequestScoped
public class ListPedidosBean implements Serializable {

	@EJB
	private PedidoBean pedidoBean;
	
	private List<Pedido> pedidos;
	
	@PostConstruct
	public void init() {
		pedidos = pedidoBean.listar();
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}
	
	public String pagar(Integer pedidoId, String tipo) throws Exception  { //ele esta perguntando se é cartão ou boleto 
		pedidoBean.pagar(pedidoId, tipo);  // optando para pagar 
		return "pedidos?faces-redirect=true";		//redirect
	}
	
	public String excluir(Integer pedidoId) {
		pedidoBean.excluir(pedidoId);
		return "pedidos?faces-redirect=true";
	}
}
