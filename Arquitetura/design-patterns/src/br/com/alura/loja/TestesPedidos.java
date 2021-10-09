package br.com.alura.loja;

import java.math.BigDecimal;
import java.util.List;

import br.com.alura.loja.orcamento.ItemOrcamento;
import br.com.alura.loja.pedido.GeraPedido;
import br.com.alura.loja.pedido.GeraPedidoHandler;
import br.com.alura.loja.pedido.acao.EnviarEmail;
import br.com.alura.loja.pedido.acao.LogDePedido;
import br.com.alura.loja.pedido.acao.SalvarPedidoNoBancoDeDados;

public class TestesPedidos {
	
	
	
	public static void main(String args[]) {
		
		ItemOrcamento item = new ItemOrcamento(BigDecimal.TEN);
		GeraPedido gerador = new GeraPedido("Antony",List.of(item));
		GeraPedidoHandler geraPedidoHandler = new GeraPedidoHandler(
				List.of(
					new EnviarEmail(), 
					new SalvarPedidoNoBancoDeDados(),
					new LogDePedido()
					)
				);
		geraPedidoHandler.execute(gerador);
	}
	

}
