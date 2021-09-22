package br.com.alura.spring_data.service;

import java.util.Scanner;

public abstract class Acao {

	private final Integer codigo;
	private final String descricao;
	
	public Acao(Integer codigo, String descricao) {
		
		this.codigo = codigo;
		this.descricao = descricao;
		
	}
	
	abstract public void iniciar(Scanner scanner);
	
	public Integer getCodigo() {
		return this.codigo;
	}
	
	public String getDescricao() {
		return this.descricao;
	}

	@Override
	public String toString() {
		return "Acao codigo : " + codigo + ", descricao=" + descricao;
	}
	
	
	
	
}
