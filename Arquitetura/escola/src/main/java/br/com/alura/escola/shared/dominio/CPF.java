package br.com.alura.escola.shared.dominio;

import java.util.Objects;

public class CPF {

	private String cpf;
	
	public CPF(String cpf){
		this.setCpf(cpf);
	}
	
	
	public void setCpf(String cpf) {
		
		if(!this.isCPFValido(cpf)) {
			throw new IllegalArgumentException("O CPF � inv�lido!");
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


	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CPF other = (CPF) obj;
		return Objects.equals(cpf, other.cpf);
	}
	
	
	
	
}
