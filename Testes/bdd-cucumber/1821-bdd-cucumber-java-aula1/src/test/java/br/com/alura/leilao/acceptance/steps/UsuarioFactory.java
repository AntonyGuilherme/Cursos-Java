package br.com.alura.leilao.acceptance.steps;

import br.com.alura.leilao.model.Usuario;

public class UsuarioFactory {

	public Usuario criarComNome(String nome){
		return this.criarUsuario(nome,null,null);
	}
	
	public Usuario criarComNomeESenha(String nomeDeUsuario, String senha) {
		return this.criarUsuario(nomeDeUsuario, null, senha);
	}
	
	
	private Usuario criarUsuario(String nome,String email,String senha) {
		return new Usuario(nome,email,senha);
	}
	
	
}
