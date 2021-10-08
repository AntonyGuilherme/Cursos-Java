package br.com.alura.loja.pedido;

import java.time.LocalDateTime;

import br.com.alura.loja.orcamento.Orcamento;

public class GeraPedidoHandler {

	
	//construtor com injecao de dependencias: repository, service, etc.
	
	public void execute(GeraPedido gerarPedido) {
		
		Orcamento orcamento = new Orcamento(gerarPedido.getValorOrcamento(),gerarPedido.getQuantidadeItens());
		
		Pedido pedido = new Pedido(gerarPedido.getCliente(), LocalDateTime.now(), orcamento);
		
		
		System.out.println("Realize ações");
	}
	
	
}
