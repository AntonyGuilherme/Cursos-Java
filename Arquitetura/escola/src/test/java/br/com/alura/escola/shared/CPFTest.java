package br.com.alura.escola.shared;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.com.alura.escola.shared.dominio.CPF;

class CPFTest {

	@Test
	void deveriaCriarUmCpfComNumeroValido() {
		
		String valorDoCPF = "324.227.110-65";
		CPF cpf = new CPF(valorDoCPF);
		
		assertEquals(valorDoCPF,cpf.getCpf());
	}
	
	
	@Test
	public void naoDeveriaCriarUmCPFComUmNumeroNulo() {
		
		assertThrows(IllegalArgumentException.class, () -> new CPF(null));		
	}
	
	@Test
	public void naoDeveriaCriarUmCPFComUmNumeroVazio() {
		
		assertThrows(IllegalArgumentException.class, () -> new CPF(""));		
	}

	@Test
	void naoDeveriaCriarUmCpfComNumerosInvalidos() {
		
		assertThrows(IllegalArgumentException.class, () -> new CPF("324.227.11"));		
	}
	
}
