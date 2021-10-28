package br.com.alura.escola;

public class CPF {

	private String cpf;
	
	public CPF(String cpf){
		this.setCpf(cpf);
	}
	
	
	public void setCpf(String cpf) {
		
		if(!this.isCPFValido(cpf)) {
			throw new IllegalArgumentException("O CPF é inválido!");
		}
		
		this.cpf = cpf;
	}
	
	private Boolean isCPFValido(String cpf) {
		return cpf != null && cpf.matches(this.getRegexParaCPF());
	}
	
	private String getRegexParaCPF() {
		return "\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}";
	}
	
	
	public String getCpf() {
		return this.cpf;
	}
	
	
}
