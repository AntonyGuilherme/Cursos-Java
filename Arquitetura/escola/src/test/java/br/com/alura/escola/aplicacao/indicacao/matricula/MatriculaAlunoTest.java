package br.com.alura.escola.aplicacao.indicacao.matricula;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.com.alura.escola.dominio.aluno.Aluno;
import br.com.alura.escola.dominio.aluno.CPF;
import br.com.alura.escola.dominio.aluno.RepositorioDeAlunos;
import br.com.alura.escola.infra.aluno.RepositorioDeAlunoEmMemoria;

class MatriculaAlunoTest {

	@Test
	void alunoDeveriaSerPersistido() {
	
		String cpf = "123.456.789-00";
		String nome = "Fulano";
		String email = "aluno@email.com";
		
		RepositorioDeAlunos repositorioDeAlunos = new RepositorioDeAlunoEmMemoria();
		MatriculaAluno useCase = new MatriculaAluno(repositorioDeAlunos);
		
		MatriculaAlunoDTO matriculaDTO = new MatriculaAlunoDTO("Fulano", "aluno@email.com", "123.456.789-00");
		useCase.matricular(matriculaDTO);
		
		Aluno alunoEncontrado = repositorioDeAlunos.buscarPorCPF(new CPF(cpf));
		
		assertEquals(nome, alunoEncontrado.getNome());
		assertEquals(email, alunoEncontrado.getEmail());
		assertEquals(cpf, alunoEncontrado.getCPF());
		
	}

}
