package br.com.alura.leilao.leiloes;

import static org.junit.Assert.assertTrue;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.leilao.login.LoginPage;

public class LeiloesTest {
	
	private LeiloesPage paginaDeLeiloes;
	private CadastroDeLeilaoPage paginaDeCadastroDeLeiloes;

	
	@BeforeEach
	public void beforeEach() {
		LoginPage paginaDeLogin = new LoginPage();
		
		this.paginaDeLeiloes = paginaDeLogin
		.preencherFormularioDeLogin("fulano", "pass")
		.efetuarLogin();
		
		this.paginaDeCadastroDeLeiloes = this.paginaDeLeiloes.navegarParaFormularioDeCriacaoDeLeiloes();
	}
	
	@AfterEach
	public void afterEach() {
		this.paginaDeLeiloes.fechar();
	}
	
	
	@Test
	public void deveriaCadastrarLeiloes() {
		
		
		DateTimeFormatter formatadorDeData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String hoje = LocalDate.now().format(formatadorDeData);
		String nome = "Leilao do dia " + hoje;
		String valor = "500.00";
		
		this.paginaDeLeiloes = this.cadastrarLeilao(nome,valor,hoje);
		
		assertTrue(paginaDeLeiloes.isLeilaoCadastrado(nome,valor,hoje));
		
	}
	
	@Test
	public void deveriaImpedirOCadastroDeLeiloesComDadosInvalidos() {
		
		this.paginaDeLeiloes = this.cadastrarLeilao("","","");
		
		assertTrue(this.paginaDeLeiloes.isPaginaLeiloes());
		assertTrue(this.paginaDeCadastroDeLeiloes.isMensagensDeValidacoesVisiveis());
		
	}
	
	private LeiloesPage cadastrarLeilao(String nome, String valor, String hoje) {
		return this.paginaDeCadastroDeLeiloes
				.preencherFormularioDeCadastroDeLeilao(nome, valor, hoje)
				.enviarFormularioDeCadastro();
	}
	

}

