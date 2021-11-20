package br.com.alura.escola.gameficacao.infra.selo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.alura.escola.academico.dominio.aluno.CPF;
import br.com.alura.escola.gameficacao.dominio.selo.RepositorioDeSelo;
import br.com.alura.escola.gameficacao.dominio.selo.Selo;

public class RepositorioDeSelosEmMemoria implements RepositorioDeSelo{

	private List<Selo> selos = new ArrayList<>();
	
	@Override
	public void registrarSelo(Selo selo) {
		
		this.selos.add(selo);	
	}

	@Override
	public List<Selo> getSelosDoAlunoDeCPF(CPF cpf) {
		
		return this.selos.stream()
				.filter((selo) -> selo.getCPFDoAluno().equals(cpf))
				.collect(Collectors.toList());
	}
	
	

}
