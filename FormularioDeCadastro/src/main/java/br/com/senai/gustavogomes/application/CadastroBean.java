package br.com.senai.gustavogomes.application;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.senai.gustavogomes.model.Linguagem;

@SuppressWarnings("serial") //ele serve para não ficar mostrando o sinal de aviso  no sistema
@RequestScoped  // ele é como se fosse uma vida curta ele vai em só uma submição e depois se encerra 
@Named("cadastro") // esta definindo o nome 

public class CadastroBean implements Serializable {  //esta implementando a variavel no serializable
	private String nome;
	private String email;
	private String senha1;
	private String senha2;
	private Character sexo;
	private Boolean receberEmails;
	private String observacoes;
	private Integer[] linguagens;
	
	
	public Linguagem[] getListaLinguagens() {  // recebendo informações da lista de LINGUAGENS  
		return Linguagem.LINGUAGENS;
	}
	
	
	
	public String getNome() { // recebendo nome 
		return nome;  // dando um retorno
	}
	public void setNome(String nome) {  // inserindo o nome 
		this.nome = nome;  //isto recebe nome = nome 
	}
	public String getEmail() { // recebendo email
		return email;
	}
	public void setEmail(String email) {  //inserindo o email 
		this.email = email;
	}
	public String getSenha1() {
		return senha1;
	}
	public void setSenha1(String senha1) {
		this.senha1 = senha1;
	}
	public String getSenha2() {
		return senha2;
	}
	public void setSenha2(String senha2) {
		this.senha2 = senha2;
	}
	public Character getSexo() {
		return sexo;
	}
	public void setSexo(Character sexo) {
		this.sexo = sexo;
	}
	public Boolean getReceberEmails() {
		return receberEmails;
	}
	public void setReceberEmails(Boolean receberEmails) {
		this.receberEmails = receberEmails;
	}
	public String getObservacoes() {
		return observacoes;
	}
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	public Integer[] getLinguagens() {
		return linguagens;
	}
	public void setLinguagens(Integer[] linguagens) {
		this.linguagens = linguagens;
	}
	
	public String getLinguagensAsString() {
		String str="";
		boolean first = true;
		for(Integer linguagem : linguagens) {
			if(!first) {  // primeiro
				str += ","; // ele vai definir um valor 
			}
			str += Linguagem.LINGUAGENS[linguagem].getNome();
			first = false;
		}
		return str;
	}
	
}
