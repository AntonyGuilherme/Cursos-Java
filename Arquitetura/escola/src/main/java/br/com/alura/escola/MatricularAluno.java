package br.com.alura.escola;

import br.com.alura.escola.academico.aplicacao.indicacao.matricula.MatriculaAluno;
import br.com.alura.escola.academico.aplicacao.indicacao.matricula.MatriculaAlunoDTO;
import br.com.alura.escola.academico.dominio.aluno.RepositorioDeAlunos;
import br.com.alura.escola.academico.dominio.eventos.LogDeAlunoMatriculado;
import br.com.alura.escola.academico.dominio.eventos.PublicadorDeEventos;
import br.com.alura.escola.academico.infra.aluno.RepositorioDeAlunoEmMemoria;

public class MatricularAluno {

	public static void main(String[] args) {
		
		String nome = "Fulano";
		String cpf = "123.456.789-00";
		String email = "fulano@emaiil.com";
		
		RepositorioDeAlunos repositorio = new RepositorioDeAlunoEmMemoria();
		
		MatriculaAlunoDTO matricular = new MatriculaAlunoDTO(nome, email, cpf);
		PublicadorDeEventos publicadorDeEventos = new PublicadorDeEventos();
		publicadorDeEventos.adicionar(new LogDeAlunoMatriculado());
		MatriculaAluno matriculaAluno = new MatriculaAluno(repositorio,publicadorDeEventos);
		matriculaAluno.matricular(matricular);
		
	}
	
	
}
