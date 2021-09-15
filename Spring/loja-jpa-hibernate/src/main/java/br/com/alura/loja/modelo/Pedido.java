package br.com.alura.loja.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Table(name="pedidos")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id ;
	
	@Column(name="valor_total")
	private BigDecimal valorTotal = new BigDecimal("0");
	private LocalDate data = LocalDate.now();
	
	// padrão :ToOne carregado antecipadamente - eager
	@ManyToOne(fetch = FetchType.LAZY)
	private Cliente cliente;
	
	// ToMany carregado se for acessado lazy
	@OneToMany(mappedBy = "pedido", cascade=CascadeType.ALL)
	private List<ItemPedido> itens = new ArrayList<>();
	
	public Pedido() {}
	
	public Pedido(Cliente cliente) {
		this.cliente = cliente;
	}

	
	public void adicionarItem(ItemPedido item) {
		
		// por ser um relacionamento bidirecional 
		// os dois itens devem se conhecer
		item.setPedido(this);
		
		this.valorTotal = this.valorTotal.add(item.getValor());
		
		this.itens.add(item);
	}
	
	
	public Long getId() {
		return Id;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public LocalDate getData() {
		return data;
	}

	public Cliente getCliente() {
		return cliente;
	}

	
}
