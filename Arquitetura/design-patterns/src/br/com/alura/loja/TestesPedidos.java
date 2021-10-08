package br.com.alura.loja;

import java.math.BigDecimal;

import br.com.alura.loja.pedido.GeraPedido;
import br.com.alura.loja.pedido.GeraPedidoHandler;

public class TestesPedidos {
	
	
	
	public static void main(String args[]) {
		
		
		GeraPedido gerador = new GeraPedido("Antony",new BigDecimal("100"),4);
		GeraPedidoHandler geraPedidoHandler = new GeraPedidoHandler(/*Dependencias*/);
		geraPedidoHandler.execute(gerador);
	}
	

}
