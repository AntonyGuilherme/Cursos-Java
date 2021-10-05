package br.com.alura.rh.model;

import java.math.BigDecimal;

public class DadosPessoais {

	
	private String nome;
	private String cpf;
	private Cargo cargo;
	private BigDecimal salario;
	
	
	public DadosPessoais(String nome, String cpf, Cargo cargo, BigDecimal salario) {
		this.nome = nome;
		this.cpf = cpf;
		this.cargo = cargo;
		this.salario = salario;
	}


	public String getNome() {
		return nome;
	}


	public String getCpf() {
		return cpf;
	}


	public Cargo getCargo() {
		return cargo;
	}


	public BigDecimal getSalario() {
		return salario;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}


	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}
	
	
	
	
	
	
	
	
}
