package br.com.alura.loja.imposto;

import java.math.BigDecimal;

import br.com.alura.loja.orcamento.Orcamento;

public abstract class Imposto {

	private Imposto outroImposto;

	public Imposto(Imposto outroImposto) {
		this.outroImposto = outroImposto;
	}

	protected abstract BigDecimal realizarCalculo(Orcamento orcamento);

	public BigDecimal calcular(Orcamento orcamento){

		BigDecimal valorImposto = this.realizarCalculo(orcamento); 
		BigDecimal valorDoOutroImposto = BigDecimal.ZERO;

		if(this.outroImposto != null){
			valorDoOutroImposto = outroImposto.realizarCalculo(orcamento);
		}

		return valorImposto.add(valorDoOutroImposto);

	}

	
}
