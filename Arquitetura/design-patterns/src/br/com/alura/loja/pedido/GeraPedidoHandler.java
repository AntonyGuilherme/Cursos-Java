package br.com.alura.loja.pedido;

import java.time.LocalDateTime;
import java.util.List;

import br.com.alura.loja.orcamento.Orcamento;
import br.com.alura.loja.pedido.acao.AcaoAposGerarPedido;
import br.com.alura.loja.pedido.acao.EnviarEmail;
import br.com.alura.loja.pedido.acao.SalvarPedidoNoBancoDeDados;

public class GeraPedidoHandler {

	
	private List<AcaoAposGerarPedido> acoes;
	
	
	//construtor com injecao de dependencias: repository, service, etc.
	public GeraPedidoHandler(List<AcaoAposGerarPedido> acoes) {
		this.acoes = acoes;
	}
	
	
	public void execute(GeraPedido gerarPedido) {
		
		Orcamento orcamento = new Orcamento(gerarPedido.getValorOrcamento(),gerarPedido.getQuantidadeItens());
		
		Pedido pedido = new Pedido(gerarPedido.getCliente(), LocalDateTime.now(), orcamento);
		
		EnviarEmail enviarEmail = new EnviarEmail();
		SalvarPedidoNoBancoDeDados salvar = new SalvarPedidoNoBancoDeDados();
		
		this.acoes.forEach(acao -> acao.executar(pedido));
		
		
		
		System.out.println("Realize ações");
	}


	
	
}
