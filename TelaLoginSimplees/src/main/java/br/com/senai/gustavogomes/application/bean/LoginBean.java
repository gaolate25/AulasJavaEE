package br.com.senai.gustavogomes.application.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@SuppressWarnings("serial")
@Named
@RequestScoped
public class LoginBean{
	
	private String nome;
	private String senha;
	
	@PostConstruct
	public void onCreate() {
		System.out.println("Bem criado");
	}
	
	@PreDestroy
	public void onDestroy() {
		System.out.println("Bean será destruido");
	}
	
	public String doLogin(){
		if("abc".equals(nome)&& "123".equals(senha)) {
			return "sucesso";
		}
		return null;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	
	
}

