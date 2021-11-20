package br.com.alura.escola.gameficacao.dominio.selo;

import java.util.List;

import br.com.alura.escola.academico.dominio.aluno.CPF;

public interface RepositorioDeSelo {

	void registrarSelo(Selo selo);
	List<Selo> getSelosDoAlunoDeCPF(CPF cpf);
	
	
}
