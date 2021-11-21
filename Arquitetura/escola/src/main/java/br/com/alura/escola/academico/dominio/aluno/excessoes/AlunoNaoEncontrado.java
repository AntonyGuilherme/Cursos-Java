package br.com.alura.escola.academico.dominio.aluno.excessoes;

public class AlunoNaoEncontrado extends RuntimeException {


	private static final long serialVersionUID = -1099383986308399142L;

	public AlunoNaoEncontrado(String cpf) {
		
		super(String.format("Aluno nao encontrado para o cpf %s",cpf));
	}
	
}
