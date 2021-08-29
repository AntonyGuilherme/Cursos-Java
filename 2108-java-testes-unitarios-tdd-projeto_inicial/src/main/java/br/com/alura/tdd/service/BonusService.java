package br.com.alura.tdd.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.modelo.ReajusteSalarialException;

public class BonusService {

	public BigDecimal calcularBonus(Funcionario funcionario) {
		BigDecimal valor = funcionario.getSalario().multiply(new BigDecimal("0.1"));
		if (valor.compareTo(new BigDecimal("1000")) > 0) {
			throw new ReajusteSalarialException("O salario do funcionario nao pode " +
					"ser maior do que 10000 reais.");
		}
		return valor.setScale(2, RoundingMode.HALF_UP);
	}

}
