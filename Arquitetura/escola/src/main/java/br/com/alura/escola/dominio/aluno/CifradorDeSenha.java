package br.com.alura.escola.dominio.aluno;

public interface CifradorDeSenha {

	String cifrarSenha(String senha);
	Boolean validarSenhaCifrada(String senhaCifrada, String senha);
	
}
