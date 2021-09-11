package br.com.alura.conexao.modelo;

public class PropriedadesConexaoException extends RuntimeException {

	// declaração da versão
	private static final long serialVersionUID = -5685589764332304847L;

	public PropriedadesConexaoException(String msg) {
		super(msg);
	}
	
	public PropriedadesConexaoException(Exception excpetion) {
		super(excpetion);
	}
	
	
}
