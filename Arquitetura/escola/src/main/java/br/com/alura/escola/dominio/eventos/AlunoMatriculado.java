package br.com.alura.escola.dominio.eventos;

import java.time.LocalDateTime;

import br.com.alura.escola.dominio.aluno.CPF;

public class AlunoMatriculado implements Evento {

	private final CPF cpfDoAluno;
	private final LocalDateTime momento;

	public AlunoMatriculado(CPF cpfDoAluno) {

		this.cpfDoAluno = cpfDoAluno;
		this.momento = LocalDateTime.now();
	}

	public String getCpf() {

		return this.cpfDoAluno.getCpf();
	}

	@Override
	public LocalDateTime momento() {

		return this.momento;
	}

}
