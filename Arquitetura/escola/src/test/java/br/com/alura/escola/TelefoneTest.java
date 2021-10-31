package br.com.alura.escola;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.com.alura.escola.dominio.aluno.Telefone;

class TelefoneTest {

	@Test
	void deveriaCriarUmTelefoneComDadosValidos() {
		
		String ddd = "31";
		String numero = "999999999";
		
		Telefone telefone = new Telefone(ddd, numero);
		
		assertEquals(ddd, telefone.getDDD());
		assertEquals(numero,telefone.getNumero());
		
	}

	
	@Test
	void naoDeveriaCriarUmTelefoneComDadosNulos() {
		
		assertThrows(IllegalArgumentException.class, () -> new Telefone(null,null));
	}
	
	@Test
	void naoDeveriaCriarUmTelefoneComDadosVazios() {
		
		assertThrows(IllegalArgumentException.class, () -> new Telefone("",""));
	}
	
	@Test
	void naoDeveriaCriarUmTelefoneComDadosUmDDDInvalidoEUmNumeroValido() {
		
		assertThrows(IllegalArgumentException.class, () -> new Telefone("1","99999999"));
	}
	
	@Test
	void naoDeveriaCriarUmTelefoneComDadosUmDDDValidoEUmNumeroInvalido() {
		
		assertThrows(IllegalArgumentException.class, () -> new Telefone("31","99"));
	}
	
	@Test
	void naoDeveriaCriarUmTelefoneComDadosInvalidos() {
		
		assertThrows(IllegalArgumentException.class, () -> new Telefone("3","999"));
	}
	
	
	
	
}
