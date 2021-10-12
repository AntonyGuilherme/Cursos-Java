package br.com.alura.leilao;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageObject {

	private WebDriver browser;

	public PageObject() {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		this.browser = new ChromeDriver();
		
		this.browser
		.manage()
		.timeouts()
		.implicitlyWait(5, TimeUnit.SECONDS) //configurando o tempo de espera em cada busca de elemento
		.pageLoadTimeout(10, TimeUnit.SECONDS); // configurando o tempo de espera para o carregamento de uma página
	}

	public PageObject(WebDriver browser) {
		this.browser = browser;
	}

	public WebDriver getBrowser() {
		return browser;
	}

	public void fechar() {
		this.browser.quit();
	}

	public void direcionarPara(String url) {
		this.browser.navigate().to(url);
	}

	public Boolean contemTextos(String... textos) {

		String codigoDaPagina = this.browser.getPageSource();
		List<String> textosEmList = List.of(textos);

		return textosEmList
				.stream()
				.map(codigoDaPagina::contains)
				.allMatch((validacaoDoTexto) -> validacaoDoTexto);

	}

}
