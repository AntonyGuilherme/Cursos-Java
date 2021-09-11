package br.com.alura.conexao.modelo;

public class ConexaoException extends RuntimeException {

	private static final long serialVersionUID = 7743174315828447523L;

	public ConexaoException(Exception exception) {
		super(exception);
	}

	
	
}
