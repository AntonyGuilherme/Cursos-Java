package br.com.alura.loja.pedido.acao;

import br.com.alura.loja.pedido.Pedido;

public class SalvarPedidoNoBancoDeDados implements AcaoAposGerarPedido {

	
	@Override
	public void executar(Pedido pedido) {
		
		System.out.println("Salavando Pedido no banco de dados");
		
	}
	
	
}
