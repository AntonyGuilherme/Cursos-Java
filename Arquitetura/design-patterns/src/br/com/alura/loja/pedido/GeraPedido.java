package br.com.alura.loja.pedido;

import java.util.List;

import br.com.alura.loja.orcamento.Orcavel;

public class GeraPedido {
	
	
	private String cliente;
	private List<Orcavel> itensOrcamento;
	
	
	public GeraPedido(String cliente,List<Orcavel> itensOrcamento) {
	
		this.cliente = cliente;
		this.itensOrcamento = itensOrcamento;
		
	}
	
	


	public List<Orcavel> getItensOrcamento() {
		return itensOrcamento;
	}


	public String getCliente() {
		return cliente;
	}
	
	
	
	
	

}
