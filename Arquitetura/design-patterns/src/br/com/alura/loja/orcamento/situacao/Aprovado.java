package br.com.alura.loja.orcamento.situacao;

import java.math.BigDecimal;

import br.com.alura.loja.orcamento.Orcamento;

public class Aprovado extends SituacaoOrcamento {

	public Aprovado() {
		super(new BigDecimal("0.02"));
	}
	
	
	@Override
	public void finalizar(Orcamento orcamento) {
		orcamento.setSituacao(new Finalizado());
	}

}
