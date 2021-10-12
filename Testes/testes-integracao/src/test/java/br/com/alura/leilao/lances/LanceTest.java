package br.com.alura.leilao.lances;

import static org.junit.Assert.assertTrue;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.leilao.leiloes.CadastroDeLeilaoPage;
import br.com.alura.leilao.leiloes.LeiloesPage;
import br.com.alura.leilao.login.LoginPage;

public class LanceTest {

	private LancePage paginaDeLance;
	
	@BeforeEach
	public void beforeEach() {
		
		LoginPage paginaDeLogin = new LoginPage();
		LeiloesPage paginaDeLeiloes = paginaDeLogin
				.preencherFormularioDeLogin("fulano", "pass")
				.efetuarLogin();
		
		CadastroDeLeilaoPage paginaDeCadastroDeLeiloes = paginaDeLeiloes.navegarParaFormularioDeCriacaoDeLeiloes();
		
		DateTimeFormatter formatadorDeData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String hoje = LocalDate.now().format(formatadorDeData);
		String nome = "Leilao do dia " + hoje;
		String valor = "500.00";
		
		paginaDeCadastroDeLeiloes
				.preencherFormularioDeCadastroDeLeilao(nome, valor, hoje)
				.enviarFormularioDeCadastro()
				.direcionarPara(LoginPage.URL_LOGIN);
		
		paginaDeLeiloes = paginaDeLogin
		.preencherFormularioDeLogin("beltrano", "pass")
		.efetuarLogin();
		
		this.paginaDeLance = paginaDeLeiloes.irParaPaginaDeLance();
		
	}
	
	
	@AfterEach
	public void afterEach() {
		this.paginaDeLance.fechar();
	}
	
	
	
	@Test
	public void deveriaRealizarUmLance() {
		
		String valorDoLance = "100";
		
		this.paginaDeLance
		.preencherFormularioDeLance(valorDoLance)
		.enviarFormularioDeLance();
		
		Boolean ItemCadastradoCorretamente = this.paginaDeLance
					.isValorLanceCadastradoCorretamente(valorDoLance);
		assertTrue(ItemCadastradoCorretamente);
		
		
	}
	
	@Test
	public void naoDeveriaRealizarUmLanceCOmUmValorInvalido() {
		
		this.paginaDeLance
		.preencherFormularioDeLance("")
		.enviarFormularioDeLance();
		
		assertTrue(this.paginaDeLance.contemTextos("não deve ser nulo"));
		
		
	}
	
	
	
	
}
