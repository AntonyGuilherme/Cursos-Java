package br.com.alura.rh.model;

import java.math.BigDecimal;

public class Terceirizado {

	private String empresa;
	private DadosPessoais dadosPessoais;
	
	public Terceirizado(String nome, String cpf, Cargo cargo, BigDecimal salario) {
		this.dadosPessoais = new DadosPessoais(nome, cpf, cargo, salario);
	}

	
	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	
	
	
	public String getNome() {
		return this.dadosPessoais.getNome();
	}

	public void setNome(String nome) {
		this.dadosPessoais.setNome(nome);
	}

	public String getCpf() {
		return this.dadosPessoais.getCpf();
	}

	public void setCpf(String cpf) {
		this.dadosPessoais.setCpf(cpf);
	}

	public Cargo getCargo() {
		return this.dadosPessoais.getCargo();
	}

	public void setCargo(Cargo cargo) {
		this.dadosPessoais.setCargo(cargo);
	}
	

	public BigDecimal getSalario() {
		return this.dadosPessoais.getSalario();
	}
	public void setSalario(BigDecimal salario) {
		this.dadosPessoais.setSalario(salario);
	}

	

}
