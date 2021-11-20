package br.com.alura.escola.gameficacao.dominio.selo;

import br.com.alura.escola.academico.dominio.aluno.CPF;

public class Selo {
	
	
	private CPF cpfDoAluno;
	private String nome;
	
	public Selo(CPF cpfDoAluno, String nome) {
		
		this.cpfDoAluno = cpfDoAluno;
		this.nome = nome;
		
	}
	
	
	public CPF getCPFDoAluno(){
		return this.cpfDoAluno;
	}
	
	public String nome() {
		return this.nome;
	}
	
	

}
