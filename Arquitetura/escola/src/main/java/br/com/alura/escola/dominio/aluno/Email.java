package br.com.alura.escola.dominio.aluno;

public class Email {

	// Value Object
	
	private String endereco;

	public Email(String endereco) {
		
		this.setEndereco(endereco);
	}


	public void setEndereco(String endereco) {
		
		if (this.isEnderecoInvalido(endereco)) {		
			throw new IllegalArgumentException("O Email informado eh invalido");
		}

			this.endereco = endereco; 
	} 
	
	private Boolean isEnderecoInvalido(String endereco) {
		
		return !this.isEnderecoValido(endereco);
	}
	
	private Boolean isEnderecoValido(String endereco) {

		Boolean isEnderecoNaoNulo = endereco != null;
		return isEnderecoNaoNulo && this.isEnderecoUmEmailValido(endereco);
	}
	
	private Boolean isEnderecoUmEmailValido(String endereco) {
		return  endereco.matches(this.getExpressaoParaValidacaoDoEndereco());
	}

	private String getExpressaoParaValidacaoDoEndereco() {
		return "^[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
	}

	public String getEmail() {
		return this.endereco;
	}
	
	
}
