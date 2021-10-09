package br.com.alura.loja;

import java.math.BigDecimal;

import br.com.alura.loja.desconto.CalculadoraDeDescontos;
import br.com.alura.loja.orcamento.Orcamento;

public class TesteDesconto {

	public static void main(String[] args) {
		
		Orcamento orcamentoQuantidade = new Orcamento(new BigDecimal("200"),6);
		Orcamento orcamentoValor = new Orcamento(new BigDecimal("600"),5);
		
		CalculadoraDeDescontos calculadora = new CalculadoraDeDescontos();
		System.out.println(calculadora.calcular(orcamentoQuantidade));
		System.out.println(calculadora.calcular(orcamentoValor));
	}

}
