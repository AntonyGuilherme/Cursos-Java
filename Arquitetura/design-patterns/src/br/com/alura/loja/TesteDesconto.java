package br.com.alura.loja;

import java.math.BigDecimal;

import br.com.alura.loja.desconto.CalculadoraDeDescontos;
import br.com.alura.loja.orcamento.ItemOrcamento;
import br.com.alura.loja.orcamento.Orcamento;

public class TesteDesconto {

	public static void main(String[] args) {
		
		ItemOrcamento item = new ItemOrcamento(BigDecimal.TEN);
		Orcamento orcamentoQuantidade = new Orcamento();
		Orcamento orcamentoValor = new Orcamento();
		
		orcamentoQuantidade.adicionarItens(item);
		orcamentoValor.adicionarItens(item);
		
		CalculadoraDeDescontos calculadora = new CalculadoraDeDescontos();
		System.out.println(calculadora.calcular(orcamentoQuantidade));
		System.out.println(calculadora.calcular(orcamentoValor));
	}

}
