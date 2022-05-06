package br.com.senai.gustavogomes.application;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.senai.gustavogomes.application.business.DataProvider;
import br.com.senai.gustavogomes.model.Endereco;
import br.com.senai.gustavogomes.model.Estado;
import br.com.senai.gustavogomes.model.Interesse;
import br.com.senai.gustavogomes.model.Pessoa;
import br.com.senai.gustavogomes.model.Telefone;

@SuppressWarnings("serial")
@RequestScoped
@Named("cadastro")
public class CadastroBean implements Serializable {
	private Pessoa pessoa;
	
	public Pessoa getPessoa() {
		if (pessoa == null) {
			pessoa = new Pessoa();
			pessoa.setEnderecoResidencial(new Endereco());
			pessoa.getEnderecoResidencial().setEstado(new Estado());
			pessoa.setEnderecoComercial(new Endereco());
			pessoa.getEnderecoComercial().setEstado(new Estado());
			pessoa.setTelefoneResidencial(new Telefone());
			pessoa.setTelefoneCelular(new Telefone());
			pessoa.setTelefoneComercial(new Telefone());
		}
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	 
	public List<Estado> getEstados(){
		return DataProvider.ESTADOS;
	}
	
	public List<Interesse> getInteresse(){
		return DataProvider.INTERESSES;
	}
}