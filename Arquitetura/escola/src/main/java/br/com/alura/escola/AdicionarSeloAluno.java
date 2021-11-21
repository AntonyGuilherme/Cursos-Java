package br.com.alura.escola;

import br.com.alura.escola.academico.dominio.aluno.Aluno;
import br.com.alura.escola.academico.dominio.aluno.FabricaDeAluno;
import br.com.alura.escola.gameficacao.dominio.selo.AdicionaSeloAluno;
import br.com.alura.escola.gameficacao.dominio.selo.AdicionaSeloDTO;
import br.com.alura.escola.gameficacao.dominio.selo.RepositorioDeSelo;
import br.com.alura.escola.gameficacao.infra.selo.RepositorioDeSelosEmMemoria;

public class AdicionarSeloAluno {

	
	
	public static void main(String args[]) {
		
		FabricaDeAluno fabricaDeAluno = new FabricaDeAluno();
		Aluno aluno = fabricaDeAluno
		.comNomeCPFEEmail("Antony", "111.111.111-11", "teste@gmail.com")
		.criarAluno();
		
		RepositorioDeSelo repositorioDeSeloEmMemoria = new RepositorioDeSelosEmMemoria();
		AdicionaSeloAluno adicionarSeloAluno = new AdicionaSeloAluno(repositorioDeSeloEmMemoria);
		AdicionaSeloDTO adicionaSeloDTO = new AdicionaSeloDTO("JAVA", aluno.getCPF());
		
		adicionarSeloAluno.adicionarSelo(adicionaSeloDTO);
		
	}
	
	
	
}
