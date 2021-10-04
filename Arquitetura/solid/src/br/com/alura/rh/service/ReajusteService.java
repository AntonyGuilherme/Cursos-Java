package br.com.alura.rh.service;

import java.math.BigDecimal;
import java.util.List;


import br.com.alura.rh.model.Funcionario;

public class ReajusteService {

	
	private List<ValidacaoReajuste> validacoes;
	
	
	public ReajusteService(List<ValidacaoReajuste> validacoes) {
		this.validacoes = validacoes;
	}



	public void reajustarSalarioDoFuncionario(Funcionario funcionario, BigDecimal aumento) {
		
		
		this.validacoes.forEach(validacao -> validacao.validar(funcionario, aumento));

		BigDecimal salarioAtual = funcionario.getSalario();
		BigDecimal salarioReajustado = salarioAtual.add(aumento);
		funcionario.atualizarSalario(salarioReajustado);
		
	}
	
	
}
