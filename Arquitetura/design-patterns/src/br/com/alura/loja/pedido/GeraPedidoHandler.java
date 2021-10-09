package br.com.alura.loja.pedido;

import java.time.LocalDateTime;
import java.util.List;

import br.com.alura.loja.orcamento.Orcamento;
import br.com.alura.loja.pedido.acao.AcaoAposGerarPedido;

public class GeraPedidoHandler {

	
	private List<AcaoAposGerarPedido> acoes;
	
	
	//construtor com injecao de dependencias: repository, service, etc.
	public GeraPedidoHandler(List<AcaoAposGerarPedido> acoes) {
		this.acoes = acoes;
	}
	
	
	public void execute(GeraPedido gerarPedido) {
		
		Orcamento orcamento = new Orcamento(gerarPedido.getValorOrcamento(),gerarPedido.getQuantidadeItens());
		
		Pedido pedido = new Pedido(gerarPedido.getCliente(), LocalDateTime.now(), orcamento);

		this.acoes.forEach(acao -> acao.executar(pedido));
		
		
		
		System.out.println("Realize a��es");
	}


	
	
}
