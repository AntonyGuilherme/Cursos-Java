package br.com.alura.leilao.login;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {
	
	public static final String URL_LOGIN = "http://localhost:8080/login";
	private WebDriver browser;

	public LoginPage() {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		this.browser = new ChromeDriver();
		this.direcionarPara(URL_LOGIN);
	}
	
	public void fechar() {
		this.browser.quit();
	}
	
	public void direcionarPara(String url) {
		this.browser.navigate().to(url);
	}
	
	public void preencherFormularioDeLogin(String username , String password) {
		this.browser.findElement(By.id("username")).sendKeys(username);
		this.browser.findElement(By.id("password")).sendKeys(password);
	}

	public void efetuarLogin() {
		this.browser.findElement(By.id("login-form")).submit();	
	}

	public Boolean isPaginaDeLogin() {
	
		return this.browser.getCurrentUrl().startsWith(LoginPage.URL_LOGIN);
	}

	public Object getNomeDoUsuarioLogado() {
		try {
			return this.browser.findElement(By.id("usuario-logado")).getText();
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	
	public Boolean contemTexto(String texto) {
		return this.browser.getPageSource().contains(texto);
	} 
	
	
	
	
}