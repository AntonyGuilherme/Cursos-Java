package br.com.alura.mvc.mudi.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="pedidos")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Pedido {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nomeProduto;
	private BigDecimal valorNegociado;
	private LocalDate dataDaEntrega;
	private String urlProduto;
	private String urlImagem;
	private String descricao;
	
	@Enumerated(EnumType.STRING)
	private StatusPedido status;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="username")
	@JsonIgnore
	private User user;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pedido", fetch = FetchType.LAZY)
	private List<Oferta> ofertas;
	
	public Pedido() {}
	
	public Pedido(String nomeProduto, BigDecimal valorNegociado, LocalDate dataDaEntrega, String urlProduto,
			String urlImagem, String descricao, StatusPedido status) {
		this.nomeProduto = nomeProduto;
		this.valorNegociado = valorNegociado;
		this.dataDaEntrega = dataDaEntrega;
		this.urlProduto = urlProduto;
		this.urlImagem = urlImagem;
		this.descricao = descricao;
		this.status = status;
	}
	
	
	
	public Long getId() {
		return id;
	}

	public User getUser() {
		return user;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public void setValorNegociado(BigDecimal valorNegociado) {
		this.valorNegociado = valorNegociado;
	}

	public void setDataDaEntrega(LocalDate dataDaEntrega) {
		this.dataDaEntrega = dataDaEntrega;
	}

	public void setUrlProduto(String urlProduto) {
		this.urlProduto = urlProduto;
	}

	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}

	public void setOfertas(List<Oferta> ofertas) {
		this.ofertas = ofertas;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}
	public BigDecimal getValorNegociado() {
		return valorNegociado;
	}
	public LocalDate getDataDaEntrega() {
		return dataDaEntrega;
	}
	public String getUrlProduto() {
		return urlProduto;
	}
	public String getUrlImagem() {
		return urlImagem;
	}
	public String getDescricao() {
		return descricao;
	}
	public StatusPedido getStatus() {
		return this.status;
	}
	
	public void setUser(User user) {
		this.user = user;
	}

	public List<Oferta> getOfertas() {
		return ofertas;
	}
	
	
}
