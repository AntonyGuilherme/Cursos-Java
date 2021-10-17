package br.com.alura.leilao.acceptance.steps;

import static org.junit.Assert.assertTrue;

import br.com.alura.leilao.e2e.pages.Browser;
import br.com.alura.leilao.e2e.pages.LeiloesPage;
import br.com.alura.leilao.e2e.pages.LoginPage;
import br.com.alura.leilao.e2e.pages.NovoLeilaoPage;
import br.com.alura.leilao.model.Usuario;
import io.cucumber.java.After;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class LeilaoSteps {

	
	private LoginPage loginPage;
	private LeiloesPage leiloesPage;
	private NovoLeilaoPage novaLeiloesPage;
	private Browser browser;

	
	@After(value = "@leilao")
	public void depoisDeCadaTeste() {
		
		this.browser.clean();
	}
	
	@Dado("um usuario logado")
	public void um_usuario_logado() {
		
		browser = new Browser();
		browser.seed();
		loginPage = browser.getLoginPage();
		
		Usuario usuario = new UsuarioFactory()
				.criarComNomeESenha("fulano", "pass");
		
		this.leiloesPage = loginPage.realizaLoginComo(usuario);
	}
	

	@Quando("acessa a pagina de novo leilao")
	public void acessa_a_pagina_de_novo_leilao() {
		this.novaLeiloesPage = this.leiloesPage.visitaPaginaParaCriarUmNovoLeilao();
	}

	@Quando("prenche o formulario com dados validos")
	public void prenche_o_formulario_com_dados_validos() {
		this.leiloesPage = this.novaLeiloesPage
				.preencheForm("PCWin", "1500", "01/11/2020");
	}

	@Entao("volta para a pagina de leiloes")
	public void volta_para_a_pagina_de_leiloes() {
		assertTrue(this.leiloesPage.estaNaPaginaDeLeiloes());
	}

	@Entao("o novo leilao aparece na tabela")
	public void o_novo_leilao_aparece_na_tabela() {
		
		this.leiloesPage.existe("PCWin", "1500", "01/11/2020","fulano");	
	}
	
	

}
