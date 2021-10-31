package br.com.alura.escola.dominio.aluno;

public class FabricaDeAluno {


	public FabricaDeCaracteristicasDeAluno comNomeCPFEEmail(String nome, String cpf, String email) {

		CPF cpfConvertidoParaObjeto = new CPF(cpf);
		Email emailConvertidoParaObjeto = new Email(email);
		
		Aluno aluno = new Aluno(cpfConvertidoParaObjeto, nome, emailConvertidoParaObjeto);
		
		return new FabricaDeCaracteristicasDeAluno(aluno);
	}


}
