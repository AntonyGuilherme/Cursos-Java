package br.com.alura.escola.gameficacao.dominio.selo;

public class AdicionaSeloAluno {

	private RepositorioDeSelo repositorioDeSelo;
	
	public AdicionaSeloAluno(RepositorioDeSelo repositorioDeSelo) {
		
		this.repositorioDeSelo = repositorioDeSelo;
	}
	
	
	public void adicionarSelo(AdicionaSeloDTO adicionaSeloDTO){
		
		this.repositorioDeSelo.registrarSelo(adicionaSeloDTO.getSelo());
		
	}
	
	
	
}
