package br.com.alura.escola;

import java.time.LocalDateTime;

public class Indicacao {
	
	private Aluno alunoIndicado;
	private Aluno alunoIndicante;
	private LocalDateTime dataIndicacao;
	
	public Indicacao(Aluno alunoIndicado, Aluno alunoIndicante) {
		
		this.alunoIndicado = alunoIndicado;
		this.alunoIndicante = alunoIndicante;
		this.dataIndicacao = LocalDateTime.now();
	}

	public Aluno getAlunoIndicado() {
		return alunoIndicado;
	}

	public Aluno getAlunoIndicante() {
		return alunoIndicante;
	}

	public LocalDateTime getDataIndicacao() {
		return dataIndicacao;
	}
	
	
	
	
	
	

}
