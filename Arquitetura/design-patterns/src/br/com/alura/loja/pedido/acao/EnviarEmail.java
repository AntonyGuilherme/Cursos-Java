package br.com.alura.loja.pedido.acao;

import br.com.alura.loja.pedido.Pedido;

public class EnviarEmail implements AcaoAposGerarPedido {

	
	@Override
	public void executar(Pedido pedido) {
		
		System.out.println("Enviando email");
		
	}
	
	
}
