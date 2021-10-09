package br.com.alura.loja.orcamento.situacao;

import java.math.BigDecimal;

import br.com.alura.loja.DomainException;
import br.com.alura.loja.orcamento.Orcamento;

public abstract class SituacaoOrcamento {

	private BigDecimal taxaDesconto;
	
	public SituacaoOrcamento(BigDecimal taxaDesconto) {
		this.taxaDesconto = taxaDesconto;
	}
	
	
	public BigDecimal calcularValorDescontoExtra(Orcamento orcamento) {
		return orcamento.getValor().multiply(taxaDesconto);
	}
	
	public void aprovar(Orcamento orcamento) {
		throw new DomainException("O Orcamento nao pode ser aprovado.");
	}
	
	public void reprovar(Orcamento orcamento) {
		throw new DomainException("O Orcamento nao pode ser reprovado.");
	}
	
	public void finalizar(Orcamento orcamento) {
		throw new DomainException("O Orcamento nao pode ser finalizar.");
	}
	
}
