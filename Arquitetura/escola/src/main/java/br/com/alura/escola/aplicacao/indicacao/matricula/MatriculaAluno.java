package br.com.alura.escola.aplicacao.indicacao.matricula;

import br.com.alura.escola.dominio.aluno.Aluno;
import br.com.alura.escola.dominio.aluno.RepositorioDeAlunos;

public class MatriculaAluno {

	private final RepositorioDeAlunos repositorioDeAluno;
	
	
	public MatriculaAluno(RepositorioDeAlunos repositorioDeAlunos) {
		
		this.repositorioDeAluno = repositorioDeAlunos;
	}

	public void matricular(MatriculaAlunoDTO dadosDaMatricula) {
		
		Aluno novoAluno = dadosDaMatricula.criarAluno();
		this.repositorioDeAluno.matricular(novoAluno);
	}
	
	
}
