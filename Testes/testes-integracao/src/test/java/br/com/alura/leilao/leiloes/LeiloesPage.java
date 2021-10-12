package br.com.alura.leilao.leiloes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.alura.leilao.PageObject;

public class LeiloesPage extends PageObject {
	
	public static final String URL_LEILOES = "http://localhost:8080/leiloes";
	public static final String URL_CADASTRO_DE_LEILOES = "http://localhost:8080/leiloes/new";

	public LeiloesPage(WebDriver browser) {
		super(browser);
	}
	

	public CadastroDeLeilaoPage navegarParaFormularioDeCriacaoDeLeiloes() {
		
		super.direcionarPara(URL_CADASTRO_DE_LEILOES);
		return new CadastroDeLeilaoPage(super.getBrowser());
	}

	public Boolean isLeilaoCadastrado(String nome, String valorInicial, String dataAbertura) {
		
		By buscarPorTagCssAUltimaLinha = this.BuscarPorTagCss("#tabela-leiloes tbody tr:last-child");
		WebElement ultimaLinhaDaTabela =  super.getBrowser().findElement(buscarPorTagCssAUltimaLinha);
		
		WebElement colunaNome = this.buscarPorItemDaLinhaDaTabela(ultimaLinhaDaTabela, 1);
		WebElement colunaDataAbertura = this.buscarPorItemDaLinhaDaTabela(ultimaLinhaDaTabela, 2);
		WebElement colunaValorInicial = this.buscarPorItemDaLinhaDaTabela(ultimaLinhaDaTabela, 3);
		
		Boolean isNomeCorreto = colunaNome.getText().equals(nome);
		Boolean isDataDeAberturaCorreta = colunaDataAbertura.getText().equals(dataAbertura);
		Boolean isValorInicalCorreto = colunaValorInicial.getText().equals(valorInicial);
		
		return isDataDeAberturaCorreta && isNomeCorreto && isValorInicalCorreto;
	} 
	
	
	private WebElement buscarPorItemDaLinhaDaTabela(WebElement linhaDaTabela, Integer indexDoItem) {
		
		String expressaoParaBusca = String.format("td:nth-child(%d)",indexDoItem);	
		By buscarPorTagCssUmItemDaLinha = this.BuscarPorTagCss(expressaoParaBusca);
		
		return linhaDaTabela.findElement(buscarPorTagCssUmItemDaLinha);
	}
	
	private By BuscarPorTagCss(String expressao) {
		return By.cssSelector(expressao);
	}
	
	
	public Boolean isPaginaLeiloes() {
		
		String paginaAtual = super.getBrowser().getCurrentUrl();
		return paginaAtual.equals(URL_LEILOES);
		
	}
	
	
	
}