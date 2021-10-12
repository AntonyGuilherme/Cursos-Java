package br.com.alura.leilao.login;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginTest {
	
	private LoginPage paginaDeLogin;

	
	@BeforeEach
	public void beforeEach() {
		this.paginaDeLogin = new LoginPage();
	}
	
	@AfterEach
	public void afterEach() {
		this.paginaDeLogin.fechar();
	}
	
	
	@Test
	public void deveriaEfetuarOLoginComDadosValidos() {
		
		this.paginaDeLogin.preencherFormularioDeLogin("fulano", "pass");
		this.paginaDeLogin.efetuarLogin();
		
		assertFalse(paginaDeLogin.isPaginaDeLogin());
		assertEquals(paginaDeLogin.getNomeDoUsuarioLogado(),"fulano");
		
	}

	@Test
	public void naoDeveriaEfetuarOLoginComDadosInvalidos() {
		
		this.paginaDeLogin.preencherFormularioDeLogin("invalido", "invalido");
		this.paginaDeLogin.efetuarLogin();
		
		assertTrue(paginaDeLogin.isPaginaDeLogin());
		assertNull(paginaDeLogin.getNomeDoUsuarioLogado());
		assertTrue(paginaDeLogin.contemTextos("Usuário e senha inválidos."));
		
	}
	
	@Test
	public void naoDeveriaAcessarPaginaRestritaSemEstarLogado() {
		
		this.paginaDeLogin.direcionarPara("http://localhost:8080/leiloes/2");
		assertTrue(this.paginaDeLogin.isPaginaDeLogin());
		assertFalse(this.paginaDeLogin.contemTextos("Dados do Leilão"));
	
	}
	

}

