package br.com.alura.escola;

import br.com.alura.escola.academico.aplicacao.indicacao.matricula.MatriculaAluno;
import br.com.alura.escola.academico.aplicacao.indicacao.matricula.MatriculaAlunoDTO;
import br.com.alura.escola.academico.dominio.aluno.RepositorioDeAlunos;
import br.com.alura.escola.academico.dominio.eventos.LogDeAlunoMatriculado;
import br.com.alura.escola.academico.infra.aluno.RepositorioDeAlunoEmMemoria;
import br.com.alura.escola.gameficacao.aplicacao.GeraSeloAlunoNovato;
import br.com.alura.escola.gameficacao.dominio.selo.RepositorioDeSelo;
import br.com.alura.escola.gameficacao.infra.selo.RepositorioDeSelosEmMemoria;
import br.com.alura.escola.shared.dominio.evento.PublicadorDeEventos;

public class MatricularAluno {

	public static void main(String[] args) {
		
		String nome = "Fulano";
		String cpf = "123.456.789-00";
		String email = "fulano@emaiil.com";
		
		RepositorioDeAlunos repositorio = new RepositorioDeAlunoEmMemoria();
		RepositorioDeSelo repositorioDeSelosEmMemoria = new RepositorioDeSelosEmMemoria();
		
		MatriculaAlunoDTO matricular = new MatriculaAlunoDTO(nome, email, cpf);
		PublicadorDeEventos publicadorDeEventos = new PublicadorDeEventos();
		
		publicadorDeEventos.adicionar(new LogDeAlunoMatriculado());
		publicadorDeEventos.adicionar(new GeraSeloAlunoNovato(repositorioDeSelosEmMemoria));

		MatriculaAluno matriculaAluno = new MatriculaAluno(repositorio,publicadorDeEventos);
		matriculaAluno.matricular(matricular);
		
	}
	
	
}
