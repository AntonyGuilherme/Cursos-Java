package br.com.alura.loja;

import java.math.BigDecimal;
import java.util.List;

import br.com.alura.loja.pedido.GeraPedido;
import br.com.alura.loja.pedido.GeraPedidoHandler;
import br.com.alura.loja.pedido.acao.EnviarEmail;
import br.com.alura.loja.pedido.acao.SalvarPedidoNoBancoDeDados;

public class TestesPedidos {
	
	
	
	public static void main(String args[]) {
		
		
		GeraPedido gerador = new GeraPedido("Antony",new BigDecimal("100"),4);
		GeraPedidoHandler geraPedidoHandler = new GeraPedidoHandler(
				List.of(new EnviarEmail(), new SalvarPedidoNoBancoDeDados())
				);
		geraPedidoHandler.execute(gerador);
	}
	

}
