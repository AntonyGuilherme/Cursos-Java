package br.com.alura.escola;

import br.com.alura.escola.aplicacao.indicacao.matricula.MatriculaAluno;
import br.com.alura.escola.aplicacao.indicacao.matricula.MatriculaAlunoDTO;
import br.com.alura.escola.dominio.aluno.RepositorioDeAlunos;
import br.com.alura.escola.dominio.eventos.LogDeAlunoMatriculado;
import br.com.alura.escola.dominio.eventos.PublicadorDeEventos;
import br.com.alura.escola.infra.aluno.RepositorioDeAlunoEmMemoria;

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
