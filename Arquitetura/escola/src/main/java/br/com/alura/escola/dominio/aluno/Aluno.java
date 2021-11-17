package br.com.alura.escola.dominio.aluno;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import br.com.alura.escola.dominio.aluno.excessoes.AlunoNumeroDeTelefonesMaximoException;

public class Aluno {

	private static final Integer QUANTIDADE_TELEFONES_MAX = 2;
	private CPF cpf;
	private String nome;
	private Email email;
	private String senha;
	private List<Telefone> telefones = new ArrayList<>();
	
	public Aluno(CPF cpf, String nome, Email email) {

		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
	}

	public String getNome() {
		return this.nome;
	}
	
	public String getEmail() {
		return this.email.getEmail();
	}
	
	public String getCPF() {

		return this.cpf.getCpf();
	}
	
	public void adicionaTelefone(String ddd, String numero) {
		
		if(!isQuantidadeDeTelefonesValidos()) {
			throw new AlunoNumeroDeTelefonesMaximoException("Numero maximo de telefones ja atingido.");
		}
		
		this.telefones.add(new Telefone(ddd,numero));
	}
	
	private Boolean isQuantidadeDeTelefonesValidos() {
		return this.telefones.size() < QUANTIDADE_TELEFONES_MAX;
	}
	
	public List<Telefone> getTelefones(){
		return Collections.unmodifiableList(this.telefones);
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
		Aluno other = (Aluno) obj;
		return Objects.equals(cpf, other.cpf);
	}


	
}
