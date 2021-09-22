package br.com.alura.spring_data.orm;

import java.math.BigDecimal;

public class FuncionarioDTO {

	private Integer id;
	private String nome;
	private BigDecimal salario;
	
	
	
	public FuncionarioDTO(Integer id , String nome , BigDecimal salario) {
		
		this.id = id;
		this.nome = nome;
		this.salario = salario;
		
	}



	public Integer getId() {
		return id;
	}



	public String getNome() {
		return nome;
	}



	public BigDecimal getSalario() {
		return salario;
	}



	@Override
	public String toString() {
		return String.format(
				"FuncionarioDTO id : %s | nome=%s | salario : %s", 
				id, nome, salario);
	}
	
	
	
	
	
	
	
}
