package br.com.alura.escola;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.com.alura.escola.dominio.aluno.Email;

class EmailTest {

	 
	@Test
	void deveriaCriarOEmailComUmEnderecoValido() {
		
		String endereco = "gmail@chucknorris.com";
		Email email = new Email(endereco);
		
		assertTrue(email.getEmail().equals(endereco));
	}

	@Test
	void naoDeveriaCiarEmailsComEnderecoInvalido() {
		
		assertThrows(IllegalArgumentException.class, () -> new Email("emailinvalido"));
		
	}
	
	@Test
	void naoDeveriaCiarUmEmailComEnderecoNulo() {
		
		assertThrows(IllegalArgumentException.class, () -> new Email(null));
	}
	
	@Test
	void naoDeveriaCiarUmEmailComEnderecoVazio() {
		
		assertThrows(IllegalArgumentException.class, () -> new Email(""));
	}
	

}
