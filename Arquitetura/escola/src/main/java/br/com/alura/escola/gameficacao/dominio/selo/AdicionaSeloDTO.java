package br.com.alura.escola.gameficacao.dominio.selo;

import br.com.alura.escola.shared.dominio.CPF;

public class AdicionaSeloDTO {

	
	private String nomeDoSelo;
	private CPF cpfDoAluno;
	
	public AdicionaSeloDTO(String nomeDoSelo , CPF cpf) {
		
		if(nomeDoSelo == null || cpf == null ) {

			throw new IllegalArgumentException("Argumentos invalidos!");
		}
		
		this.nomeDoSelo = nomeDoSelo;
		this.cpfDoAluno = cpf;
	}
	
	
	public Selo getSelo() {
		
		return new Selo(this.cpfDoAluno,this.nomeDoSelo);
	}

}
