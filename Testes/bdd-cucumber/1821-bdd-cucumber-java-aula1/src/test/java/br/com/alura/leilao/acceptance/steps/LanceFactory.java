package br.com.alura.leilao.acceptance.steps;

import java.math.BigDecimal;
import java.util.Map;

import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Usuario;

public class LanceFactory {

	public Lance criarPorDataTable(Map<String,String> dadosDoLance) {
		
		String nomeDoUsuario = dadosDoLance.get("usuario");
		String valorDoLance = dadosDoLance.get("valor");
		BigDecimal valorDoLanceConvertido = new BigDecimal(valorDoLance);

		return this.criarLance(nomeDoUsuario, valorDoLanceConvertido);
	}
	
	
	private Lance criarLance(String nomeDoUsuario, BigDecimal valor) {
		return new Lance(this.criarUsuario(nomeDoUsuario),valor);
	}
	
	private Usuario criarUsuario(String nomeDoUsuario) {
		return new UsuarioFactory().criarUsuarioComNome(nomeDoUsuario);
	}
	
	
}
