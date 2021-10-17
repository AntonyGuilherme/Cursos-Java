package br.com.alura.leilao.acceptance.steps;

import static org.junit.Assert.assertTrue;

import br.com.alura.leilao.e2e.pages.Browser;
import br.com.alura.leilao.e2e.pages.LeiloesPage;
import br.com.alura.leilao.e2e.pages.LoginPage;
import br.com.alura.leilao.model.Usuario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class LoginSteps {

	
	private Browser browser;
	private LoginPage loginPage;
	private LeiloesPage leiloesPage;
	private Usuario usuario;
	private UsuarioFactory usuarioFactory;
	
	
	@Before
	public void antesDeCadaTeste() {
		browser = new Browser();
		this.browser.seed();
		loginPage = browser.getLoginPage();
		this.usuarioFactory = new UsuarioFactory();
	}
	
	@After
	public void depoisDeCadaTeste() {
		
		this.browser.clean();
	}
	
	
	@Dado("o usuario {string} com senha {string}")
	public void o_usuario_valido(String nomeDeUsuario, String senha) {
		
		this.usuario = this.usuarioFactory.criarComNomeESenha(nomeDeUsuario, senha);
	}


	@Quando("realiza login")
	public void realiza_login() {
		
		this.leiloesPage = this.loginPage.realizaLoginComo(this.usuario);
	}
	
	
	@Entao("eh redirecionado para a pagina de leiloes")
	public void eh_redirecionado_para_a_pagina_de_leiloes() {

		assertTrue(this.leiloesPage.estaNaPaginaDeLeiloes());		
	}
	

	@Entao("continua na pagina de login")
	public void continua_na_pagina_de_login() {
	    
		assertTrue(this.loginPage.estaNaPaginaDeLoginComErro());		
	}
	
	
}
