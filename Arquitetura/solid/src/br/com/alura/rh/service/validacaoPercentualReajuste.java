package br.com.alura.rh.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.alura.rh.model.Funcionario;

public class validacaoPercentualReajuste implements ValidacaoReajuste {

	public void validar(Funcionario funcionario, BigDecimal aumento) {
		
		BigDecimal salarioAtual = funcionario.getSalario();
		BigDecimal percentualReajuste = aumento.divide(salarioAtual, RoundingMode.HALF_UP);
		if (percentualReajuste.compareTo(new BigDecimal("0.4")) > 0) {
		}
		
	}
	
	
}
