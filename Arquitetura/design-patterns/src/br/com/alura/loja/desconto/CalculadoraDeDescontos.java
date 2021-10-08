package br.com.alura.loja.desconto;

import java.math.BigDecimal;

import br.com.alura.loja.orcamento.Orcamento;

public class CalculadoraDeDescontos {

	
	public BigDecimal calcular(Orcamento orcamento) {
		
		Desconto semDesconto = new SemDesconto();
		Desconto descontoMaiorQueQuinhentos = new DescontoParaOrcamentoComValorMaiorQueQuinhentos(semDesconto);
		Desconto descontoMaiorQueCincoItens = new DescontoParaOrcamentoComMaisDeCincoItens(descontoMaiorQueQuinhentos);
		
		return descontoMaiorQueCincoItens.efetuarCalculo(orcamento);
		
	} 
	
	
}
