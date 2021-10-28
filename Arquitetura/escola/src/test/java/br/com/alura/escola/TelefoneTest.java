package br.com.alura.escola;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TelefoneTest {

	@Test
	void deveriaCriarUmTelefoneComDadosValidos() {
		
		String ddd = "31";
		String numero = "99999999";
		
		Telefone telefone = new Telefone(ddd, numero);
		
		assertEquals(ddd, telefone.getDDD());
		assertEquals(numero,telefone.getNumero());
		
	}

	
	@Test
	void naoDeveriaCriarUmTelefoneComDadosInvalidos() {
		

		assertThrows(IllegalArgumentException.class, () -> new Telefone(null,null));
		assertThrows(IllegalArgumentException.class, () -> new Telefone("3","999"));
		assertThrows(IllegalArgumentException.class, () -> new Telefone("31","99"));
		assertThrows(IllegalArgumentException.class, () -> new Telefone("1","99999999"));
	}
	
	
}
