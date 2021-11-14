package br.com.alura.escola;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.com.alura.escola.dominio.aluno.Aluno;
import br.com.alura.escola.dominio.aluno.FabricaDeAluno;

class AlunoTest {

	@Test
	void deveriaCriarUmAlunoComDadosValidos() {
		
		String nomeDoAluno = "Antony";
		String cpfDoAluno = "324.227.110-65";
		String emailDoAluno = "antony@email.com";
		String ddd = "31";
		String numeroDeTelefone = "99999999";
		
		FabricaDeAluno fabricaDeAluno = new FabricaDeAluno();
		
		Aluno aluno = fabricaDeAluno
				.comNomeCPFEEmail(nomeDoAluno,cpfDoAluno,emailDoAluno)
				.comTelefone(ddd, numeroDeTelefone)
				.criarAluno();
		
		assertEquals(nomeDoAluno, aluno.getNome());
		assertEquals(emailDoAluno, aluno.getEmail());
		
	}

}
