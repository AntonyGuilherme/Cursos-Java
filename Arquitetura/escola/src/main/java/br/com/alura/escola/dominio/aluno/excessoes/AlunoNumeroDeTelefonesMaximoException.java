package br.com.alura.escola.dominio.aluno.excessoes;

public class AlunoNumeroDeTelefonesMaximoException extends RuntimeException {
	
	public AlunoNumeroDeTelefonesMaximoException(String mensagem) {
		super(mensagem);
	}

}
