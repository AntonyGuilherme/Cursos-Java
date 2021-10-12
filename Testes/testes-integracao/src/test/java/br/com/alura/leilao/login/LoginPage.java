package br.com.alura.leilao.login;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import br.com.alura.leilao.PageObject;
import br.com.alura.leilao.leiloes.LeiloesPage;

public class LoginPage extends PageObject {
	
	public static final String URL_LOGIN = "http://localhost:8080/login";;

	public LoginPage() {
		super();
		this.direcionarPara(URL_LOGIN);
	}
	
	public void preencherFormularioDeLogin(String username , String password) {
		super.getBrowser().findElement(By.id("username")).sendKeys(username);
		super.getBrowser().findElement(By.id("password")).sendKeys(password);
	}

	public LeiloesPage efetuarLogin() {
		super.getBrowser().findElement(By.id("login-form")).submit();
		return new LeiloesPage(super.getBrowser());
	}

	public Boolean isPaginaDeLogin() {
	
		return super.getBrowser().getCurrentUrl().startsWith(LoginPage.URL_LOGIN);
	}

	public Object getNomeDoUsuarioLogado() {
		try {
			return super.getBrowser().findElement(By.id("usuario-logado")).getText();
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	
	
	
}