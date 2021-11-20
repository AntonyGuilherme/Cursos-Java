package br.com.alura.escola.gameficacao.dominio.selo;

import br.com.alura.escola.academico.dominio.aluno.Aluno;
import br.com.alura.escola.academico.dominio.aluno.CPF;

public class AdicionaSeloDTO {

	
	private String nomeDoSelo;
	private CPF cpfDoAluno;
	
	public AdicionaSeloDTO(String nomeDoSelo , Aluno aluno) {
		
		if(nomeDoSelo == null || aluno == null ) {

			throw new IllegalArgumentException("Argumentos invalidos!");
		}
		
		this.nomeDoSelo = nomeDoSelo;
		this.cpfDoAluno = aluno.getCPF();
	}
	
	
	public Selo getSelo() {
		
		return new Selo(this.cpfDoAluno,this.nomeDoSelo);
	}

}
