package br.com.alura.loja.orcamento;

import java.math.BigDecimal;

import br.com.alura.loja.orcamento.situacao.EmAnalise;
import br.com.alura.loja.orcamento.situacao.SituacaoOrcamento;

public class Orcamento {

	private BigDecimal valor;
	private Integer quantidadeItens;
	private SituacaoOrcamento situacao;

	
	
	public Orcamento(BigDecimal valor) {
		this.valor = valor;
		this.quantidadeItens = 1;
		this.situacao = new EmAnalise();
	}

	
	public Orcamento(BigDecimal valor , Integer quantidadeItens) {
		this.valor = valor;
		this.quantidadeItens = quantidadeItens;
	}
	
	
	public void aplicarDescontoExtra() {
		
		BigDecimal valorDoDescontoExtra = this.getSituacao().calcularValorDescontoExtra(this);
		
		this.valor = this.valor.subtract(valorDoDescontoExtra);
	}
	
	public void aprovar() {
		this.situacao.aprovar(this);
	}
	
	public void reprovar() {
		this.situacao.reprovar(this);
	}
	public void finalizar() {
		this.situacao.finalizar(this);
	}


	public BigDecimal getValor() {
		return this.valor;
	}
	
	public Integer getQuantidade() {
		return this.quantidadeItens;
	}


	public void setSituacao(SituacaoOrcamento situacao) {
		this.situacao = situacao;
	}
	
	public SituacaoOrcamento getSituacao() {
		return this.situacao;
	}
	
	
	
	
	
}
