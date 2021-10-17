package br.com.alura.leilao.acceptance.steps;

import br.com.alura.leilao.model.Usuario;

public class UsuarioFactory {

	public Usuario criarUsuarioComNome(String nome){
		return new Usuario(nome);
	}
	
}
