package br.com.alura.jdbc.modelo;

public class Produto {

	private Integer id;
	private String nome;
	private String descricao;
	
	public Produto(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}
	
	public Produto(Integer id,String nome, String descricao) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setId(int id) {
		this.id = id;
		
	}

	@Override
	public String toString() {
		return String.format("id %d nome %s descricao %s",id, nome,descricao);
	}
	
	
	
	
	
	
	
	
	
	
	
}
