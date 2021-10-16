package br.com.alura.leilao.acceptance.steps;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;

import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class PropondoLancesSteps {

	private Lance lance;
	private Leilao leilao;
	private ArrayList<Lance> lista;
	
	
	@Before
	public void setUp() {
		this.lista = new ArrayList<Lance>();
		leilao = new Leilao("Tablet XPTO");
	}
	
	@After
	public void tearDown() {
		
	}
	

	@Dado("um lance valido")
	public void dado_um_lance_valido() {

		Usuario usuario = new Usuario("fulano");
		this.lance = new Lance(usuario, BigDecimal.TEN);

	}

	@Quando("propoe ao leilao")
	public void quando_propoe_o_lance() {

		leilao.propoe(lance);

	}

	@Entao("o lance eh aceito")
	public void entao_o_lance_eh_aceito() {

		Integer quantidadeDeLances = leilao.getLances().size();
		Lance lanceInserido = leilao.getLances().get(0);

		assertEquals(1, quantidadeDeLances);
		assertNotNull(lanceInserido);
		assertEquals(BigDecimal.TEN, lanceInserido.getValor());

	}

	/*
	 * @Dado("varios lances validos") public void varios_lances_validos() {
	 * 
	 * Usuario usuario1 = new Usuario("fulano"); this.lance10 = new Lance(usuario1,
	 * BigDecimal.TEN);
	 * 
	 * Usuario usuario2 = new Usuario("beltrano"); this.lance15 = new
	 * Lance(usuario2, new BigDecimal("15.0"));
	 * 
	 * 
	 * }
	 */

	@Dado("um lance de {double} reais do usuario {string}")
	public void um_lance_de_reais_do_usuario(Double valorLance, String nomeDoUsuario) {
		
		Usuario usuario = new Usuario(nomeDoUsuario);
		BigDecimal valorConvertido = new BigDecimal(valorLance);
		Lance lance = new Lance(usuario,valorConvertido);
		this.lista.add(lance);
		
	}

	@Quando("propoe varios lances ao leilao")
	public void propoe_varios_lances_ao_leilao() {

		this.lista.forEach(leilao::propoe);

	}

	@Entao("os lances sao aceitos")
	public void os_lances_sao_aceitos() {

		Integer quantidadeDeLancesPropostos = leilao.getLances().size();
		Integer quantidadeDeLancesCriados = this.lista.size();
		Lance lanceInseridoComValor10 = leilao.getLances().get(0);
		Lance lanceInseridoComValor15 = leilao.getLances().get(1);
		BigDecimal valorCriado10 = this.lista.get(0).getValor();
		BigDecimal valorCriado15 = this.lista.get(1).getValor();
		
		assertEquals(quantidadeDeLancesPropostos, quantidadeDeLancesCriados);
		assertNotNull(lanceInseridoComValor10);
		assertNotNull(lanceInseridoComValor15);
		assertEquals(valorCriado10, lanceInseridoComValor10.getValor());
		assertEquals(valorCriado15, lanceInseridoComValor15.getValor());

	}

}