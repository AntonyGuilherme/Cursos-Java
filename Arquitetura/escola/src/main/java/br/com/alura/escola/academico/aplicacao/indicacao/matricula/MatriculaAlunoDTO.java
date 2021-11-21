package br.com.alura.escola.academico.aplicacao.indicacao.matricula;

import br.com.alura.escola.academico.dominio.aluno.Aluno;
import br.com.alura.escola.academico.dominio.aluno.FabricaDeAluno;
import br.com.alura.escola.academico.dominio.aluno.FabricaDeCaracteristicasDeAluno;

public class MatriculaAlunoDTO {

	private String nomeAluno;
	private String email;
	private String cpf;
	
	public MatriculaAlunoDTO(String nomeAluno, String email, String cpf) {

		this.nomeAluno = nomeAluno;
		this.email = email;
		this.cpf = cpf;
	}
	
	
	public Aluno criarAluno(){
		
		FabricaDeAluno fabricaDeAluno = new FabricaDeAluno();
		FabricaDeCaracteristicasDeAluno caracteristicasAluno = fabricaDeAluno.comNomeCPFEEmail(nomeAluno, cpf, email);
		
		return caracteristicasAluno.criarAluno();
		
	}
	
	
}
