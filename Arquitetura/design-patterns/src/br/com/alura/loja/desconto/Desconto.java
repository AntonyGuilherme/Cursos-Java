package br.com.alura.loja.desconto;

import java.math.BigDecimal;

import br.com.alura.loja.orcamento.Orcamento;

public abstract class Desconto {

	private Desconto proximo;
	
	
	public Desconto(Desconto proximo) {
		this.proximo = proximo;
	}

	protected abstract Boolean deveAplicar(Orcamento orcamento);
	protected abstract BigDecimal efetuarCalculo(Orcamento orcamento);
	
	
	public BigDecimal calcular(Orcamento orcamento) {
		
		if(deveAplicar(orcamento)) {
			return efetuarCalculo(orcamento);
		}
		
		return this.getProximo().calcular(orcamento);
	}
	
	
	public Desconto getProximo() {
		return this.proximo;
	}
	
	
}
