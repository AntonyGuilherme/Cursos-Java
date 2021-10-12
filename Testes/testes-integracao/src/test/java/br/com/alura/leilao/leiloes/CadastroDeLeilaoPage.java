package br.com.alura.leilao.leiloes;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.alura.leilao.PageObject;
import br.com.alura.leilao.login.LoginPage;

public class CadastroDeLeilaoPage extends PageObject {

	
	private static final String URL_CADASTRO_LEILAO = "http://localhost:8080/leiloes/new";

	public CadastroDeLeilaoPage(WebDriver browser) {
		super(browser);
	}
	

	public CadastroDeLeilaoPage preencherFormularioDeCadastroDeLeilao(
			String nome, 
			String valorInicial, 
			String dataAbertura) {

		super.getBrowser().findElement(By.id("nome")).sendKeys(nome);
		super.getBrowser().findElement(By.id("valorInicial")).sendKeys(valorInicial);
		super.getBrowser().findElement(By.id("dataAbertura")).sendKeys(dataAbertura);
		
		return this;
	}
	
	
	public LeiloesPage enviarFormularioDeCadastro() {

		super.getBrowser().findElement(By.id("button-submit")).click();
		
		return new LeiloesPage(super.getBrowser());
	}
	

	public Boolean isPaginaAtual() {
		
		String urlAtual =  super.getBrowser().getCurrentUrl();
		
		return urlAtual.equals(URL_CADASTRO_LEILAO);
	}

	public Boolean isMensagensDeValidacoesVisiveis() {
		
		return 	super.contemTextos(
				"minimo 3 caracteres",
				"não deve estar em branco",
				"deve ser um valor maior de 0.1",
				"deve ser uma data no formato dd/MM/yyyy");
	}

	
	
	
}