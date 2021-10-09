package br.com.alura.loja.orcamento;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.loja.orcamento.situacao.EmAnalise;
import br.com.alura.loja.orcamento.situacao.Finalizado;
import br.com.alura.loja.orcamento.situacao.SituacaoOrcamento;

public class Orcamento implements Orcavel {

	private BigDecimal valor;
	private SituacaoOrcamento situacao;
	private List<Orcavel> itens;

	public Orcamento() {
		this.valor = BigDecimal.ZERO;
		this.situacao = new EmAnalise();
		this.itens = new ArrayList<>();
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

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

		return this.valor;
	}

	public Integer getQuantidade() {
		return this.itens.size();
	}

	public void setSituacao(SituacaoOrcamento situacao) {
		this.situacao = situacao;
	}

	public SituacaoOrcamento getSituacao() {
		return this.situacao;
	}

	public Boolean isFinalizado() {
		return this.situacao instanceof Finalizado;
	}

	public void adicionarItens(Orcavel ...itensParaAdicionar) {
		List<Orcavel> itensEmFormatoDeLista = List.of(itensParaAdicionar);
		this.adicionarItens(itensEmFormatoDeLista);
	}

	public void adicionarItens(List<Orcavel> itensParaAdicionar) {
		itensParaAdicionar.forEach(this.itens::add);
		itensParaAdicionar.forEach(this::adicionarValorDoItem);
	}

	private void adicionarValorDoItem(Orcavel item){
		this.valor = this.valor.add(item.getValor());
	}

}
