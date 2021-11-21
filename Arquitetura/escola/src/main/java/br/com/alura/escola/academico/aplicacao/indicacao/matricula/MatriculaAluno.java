package br.com.alura.escola.academico.aplicacao.indicacao.matricula;

import br.com.alura.escola.academico.dominio.aluno.Aluno;
import br.com.alura.escola.academico.dominio.aluno.RepositorioDeAlunos;
import br.com.alura.escola.academico.dominio.eventos.AlunoMatriculado;
import br.com.alura.escola.shared.dominio.CPF;
import br.com.alura.escola.shared.dominio.evento.PublicadorDeEventos;

public class MatriculaAluno {

	private final RepositorioDeAlunos repositorioDeAluno;
	private final PublicadorDeEventos publicador;
	
	
	public MatriculaAluno(RepositorioDeAlunos repositorioDeAlunos, PublicadorDeEventos publicador) {
		
		this.repositorioDeAluno = repositorioDeAlunos;
		this.publicador = publicador;
	}

	public void matricular(MatriculaAlunoDTO dadosDaMatricula) {
		
		Aluno novoAluno = dadosDaMatricula.criarAluno();
		this.repositorioDeAluno.matricular(novoAluno);
		this.registrarEventoDeMatricula(novoAluno);
	}
	
	public void registrarEventoDeMatricula(Aluno aluno) {
		
		CPF cpfDoAluno = new CPF(aluno.getNumeroDoCPF());
		AlunoMatriculado eventoAlunoMatriculado = new AlunoMatriculado(cpfDoAluno);
		this.publicador.publicar(eventoAlunoMatriculado);
		
	}
	
	
}
