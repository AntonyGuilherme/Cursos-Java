package br.com.alura.mvc.mudi.model;


import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="ofertas")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Oferta {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private BigDecimal valor;
	
	private LocalDate dataDaEntrega;
	
	private String comentario;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Pedido pedido;
	
	
	public Oferta(BigDecimal valor, LocalDate dataDaEntrega, String comentario) {
		this.valor = valor;
		this.dataDaEntrega = dataDaEntrega;
		this.comentario = comentario;
	}
	
	public Oferta() {}

	public Long getId() {
		return id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public LocalDate getDataDaEntrega() {
		return dataDaEntrega;
	}

	public String getComentario() {
		return comentario;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public void setDataDaEntrega(LocalDate dataDaEntrega) {
		this.dataDaEntrega = dataDaEntrega;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	
	
	
	
	
}
