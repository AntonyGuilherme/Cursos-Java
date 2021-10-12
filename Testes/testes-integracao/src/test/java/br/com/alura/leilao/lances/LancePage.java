package br.com.alura.leilao.lances;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.alura.leilao.PageObject;

public class LancePage extends PageObject {

	
	public LancePage(WebDriver browser) {
		super(browser);
	}
	
	
	public LancePage preencherFormularioDeLance(String valor) {
		this.getBrowser().findElement(By.id("valor")).sendKeys(valor);
		return this;
	}
	
	public LancePage preencherFormularioDeLance() {
		this.preencherFormularioDeLance("100");
		return this;
	}
	
	public void enviarFormularioDeLance() {
		this.getBrowser().findElement(By.id("btnDarLance")).click();
	}
	
	public WebElement buscarPorUltimaLinhaDaTabela() {
		return super.buscarPorUltimaLinhaDaTabela("lancesDados");
	}
	
	public Boolean isValorLanceCadastradoCorretamente(String valor) {
		
		WebElement ultimaLinhaDaTabela = this.buscarPorUltimaLinhaDaTabela();
		WebElement colunaValor = this.buscarPorItemDaLinhaDaTabela(ultimaLinhaDaTabela, 3);
		String valorDaTabela = colunaValor.getText();
		return valorDaTabela.contains(valor);
	}
	
}
