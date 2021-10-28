package br.com.alura.escola;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CPFTest {

	@Test
	void deveriaCriarUmCpfComNumeroValido() {
		
		String valorDoCPF = "324.227.110-65";
		CPF cpf = new CPF(valorDoCPF);
		
		assertEquals(valorDoCPF,cpf.getCpf());
	}
	
	@Test
	void naoDeveriaCriarUmCpfComNumerosInvalidos() {
		
		assertThrows(IllegalArgumentException.class, () -> new CPF("324.227.11"));
		assertThrows(IllegalArgumentException.class, () -> new CPF(null));
	}

}
