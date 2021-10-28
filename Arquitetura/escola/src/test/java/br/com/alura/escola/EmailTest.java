package br.com.alura.escola;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EmailTest {

	@Test
	void naoDeveriaCiarEmailsComEnderecosInvalidos() {
		
		assertThrows(IllegalArgumentException.class, () -> new Email(null));
		assertThrows(IllegalArgumentException.class, () -> new Email(""));
		assertThrows(IllegalArgumentException.class, () -> new Email("emailinvalido"));
		
	}
	 
	@Test
	void deveriaCriarOEmailComUmEnderecoValido() {
		
		String endereco = "gmail@chucknorris.com";
		Email email = new Email(endereco);
		
		assertTrue(email.getEmail().equals(endereco));
	}

}
