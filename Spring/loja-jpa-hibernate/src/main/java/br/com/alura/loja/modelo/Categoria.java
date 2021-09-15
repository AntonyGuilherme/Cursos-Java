package br.com.alura.loja.modelo;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="categorias")
public class Categoria  {

	
	
	@EmbeddedId
	private CategoriaId  id;
	
	
	
	public Categoria() {}
	
	public Categoria(String nome) {
		this.id = new CategoriaId(nome,"teste");
	}
	
	public String getNome() {
		return this.id.getNome();
	}
	

	@Override
	public String toString() {
		return "Categoria [nome=" + this.id.getNome() + "]";
	}

	public void setNome(String nome) {
		this.id.setNome(nome);
	}
	
	
	
}
