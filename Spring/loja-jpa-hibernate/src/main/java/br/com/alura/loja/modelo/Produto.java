package br.com.alura.loja.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;



@Entity
@Table(name="produtos")
@NamedQuery(
		name="produtosPorCategoria", 
		query="SELECT P FROM Produto P WHERE P.categoria.id.nome = ?1" 
)

//tabela com todos os atributos das classes filhas InheritanceType.SINGLE_TABLE
@Inheritance(strategy=InheritanceType.JOINED) 
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	//@Column(name="desc") caso não fosse o mesmo nome da tabela
	private String descricao;
	private BigDecimal preco;
	private LocalDate dataCadastroDate = LocalDate.now();
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Categoria categoria;
	
	public Produto() {}
	
	public Produto(String nome, String descricao, BigDecimal preco, Categoria categoria) {
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.categoria = categoria;
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
		Produto other = (Produto) obj;
		return Objects.equals(id, other.id);
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public LocalDate getDataCadastroDate() {
		return dataCadastroDate;
	}

	public void setDataCadastroDate(LocalDate dataCadastroDate) {
		this.dataCadastroDate = dataCadastroDate;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", preco=" + preco
				+ ", dataCadastroDate=" + dataCadastroDate + ", categoria=" + categoria + "]";
	}

	
	
	
	
	
	
	
	

}
