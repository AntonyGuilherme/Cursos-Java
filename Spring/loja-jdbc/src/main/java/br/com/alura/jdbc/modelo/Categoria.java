package br.com.alura.jdbc.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


public class Categoria {

	private Integer id;
	private String nome;
	private final List<Produto> produtos = new ArrayList<>(); 
	
	
	public Categoria(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	
	public Integer getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		return Objects.equals(id, other.id);
	}


	public void adicionarProduto(Produto produto) {
		this.produtos.add(produto);
	}
	
	public List<Produto> getProdutos() {
		return Collections.unmodifiableList(this.produtos);
	}


	@Override
	public String toString() {
		return "Categoria [nome=" + nome + ", produtos=" + produtos + "]";
	}
	
	
	
	
	
}
