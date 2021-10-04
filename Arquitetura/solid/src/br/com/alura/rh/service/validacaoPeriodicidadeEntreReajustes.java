package br.com.alura.rh.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import br.com.alura.rh.ValidacaoException;
import br.com.alura.rh.model.Funcionario;

public class validacaoPeriodicidadeEntreReajustes implements ValidacaoReajuste {

	public void validar(Funcionario funcionario, BigDecimal aumento) {
		
		LocalDate dataUltimaReajuste = funcionario.getDataUltimoReajuste();
		LocalDate dataAtual = LocalDate.now();
		
		long mesesdesdeUltimoReajuste = ChronoUnit.MONTHS.between(dataUltimaReajuste, dataAtual);
		
		if(mesesdesdeUltimoReajuste  < 6) {
			throw new ValidacaoException("Intervalo entre reajustes deve ser de no mínimo seis meses!");	
		}
		
	}
	
	
}
