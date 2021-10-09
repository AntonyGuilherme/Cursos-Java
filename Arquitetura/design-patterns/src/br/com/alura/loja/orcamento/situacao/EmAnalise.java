package br.com.alura.loja.orcamento.situacao;

import java.math.BigDecimal;

import br.com.alura.loja.orcamento.Orcamento;

public class EmAnalise extends SituacaoOrcamento {

	public EmAnalise() {
		super(new BigDecimal("0.05"));
	}

	public void aprovar(Orcamento orcamento) {
		orcamento.setSituacao(new Aprovado());
	}
	
	public void reprovar(Orcamento orcamento) {
		orcamento.setSituacao(new Reprovado());
	}
	
}
