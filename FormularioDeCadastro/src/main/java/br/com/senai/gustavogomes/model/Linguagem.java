package br.com.senai.gustavogomes.model;

public class Linguagem {
	private Integer id;
	private String nome;
	
	public static final Linguagem[] LINGUAGENS;
		
	static {
		LINGUAGENS = new Linguagem[5];  // colocando informa��es em novas linguagens e de 0 a 4  
		
		LINGUAGENS[0] = new Linguagem(1, "Java"); // informa�oes 
		LINGUAGENS[1] = new Linguagem(2, "IOS");  // informa�oes 
		LINGUAGENS[2] = new Linguagem(3, "C++"); // informa�oes 
		LINGUAGENS[3] = new Linguagem(4, "C#"); // informa�oes 
		LINGUAGENS[4] = new Linguagem(5, "PHP"); // informa�oes 
		
		
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Linguagem(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}
}


