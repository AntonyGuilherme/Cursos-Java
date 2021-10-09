package br.com.alura.loja;

import java.math.BigDecimal;

import br.com.alura.loja.imposto.CalcularImpostos;
import br.com.alura.loja.imposto.ICMS;
import br.com.alura.loja.imposto.ISS;
import br.com.alura.loja.imposto.Imposto;
import br.com.alura.loja.orcamento.ItemOrcamento;
import br.com.alura.loja.orcamento.Orcamento;

public class TesteImposto {

	public static void main(String[] args) {
		
		ItemOrcamento item = new ItemOrcamento(new BigDecimal("100"));
		Orcamento orcamento = new Orcamento();
		orcamento.adicionarItens(item);
		CalcularImpostos calculadora = new CalcularImpostos();
		Imposto icms = new ICMS();
		Imposto iss = new ISS(icms);
		System.out.println(calculadora.calcular(orcamento, iss));
	}

}
