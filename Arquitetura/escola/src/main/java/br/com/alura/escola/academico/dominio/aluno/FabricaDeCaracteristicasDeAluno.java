package br.com.alura.escola.academico.dominio.aluno;

public class FabricaDeCaracteristicasDeAluno {

	private Aluno aluno;
	
	public FabricaDeCaracteristicasDeAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	public FabricaDeCaracteristicasDeAluno comTelefone(String ddd,String numero) {
		
		this.aluno.adicionaTelefone(ddd, numero);
		return this;
	}
	
	public Aluno criarAluno() {
		return this.aluno;
	}
	
	
	
}
