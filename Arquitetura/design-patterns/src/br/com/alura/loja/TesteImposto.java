package br.com.alura.loja;

import java.math.BigDecimal;

import br.com.alura.loja.imposto.CalcularImpostos;
import br.com.alura.loja.imposto.ISS;
import br.com.alura.loja.orcamento.Orcamento;

public class TesteImposto {

	public static void main(String[] args) {
		
		Orcamento orcamento = new Orcamento(new BigDecimal("100"));
		CalcularImpostos calculadora = new CalcularImpostos();
		System.out.println(calculadora.calcular(orcamento, new ISS()));
	}

}
