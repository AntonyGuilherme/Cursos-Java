package br.com.alura.loja.desconto;

import java.math.BigDecimal;

import br.com.alura.loja.orcamento.Orcamento;

public class DescontoParaOrcamentoComMaisDeCincoItens extends Desconto {

	public DescontoParaOrcamentoComMaisDeCincoItens(Desconto proximo) {
		super(proximo);
	}

	public BigDecimal calcular(Orcamento orcamento) {

		if (orcamento.getQuantidade() > 5) {
			return orcamento.getValor().multiply(new BigDecimal("0.1"));
		}

		return super.getProximo().calcular(orcamento);

	}

}
