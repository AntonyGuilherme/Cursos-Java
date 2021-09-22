package br.com.alura.spring_data.orm;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


@Entity
@Table(name="funcionarios")
public class Funcionario {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String cpf;
	private BigDecimal salario;
	
	@Column(name="data_contratacao")
	private LocalDate dataContratacao = LocalDate.now();
	
	@ManyToOne()
	@JoinColumn(name = "cargo_id", nullable = false)
	private Cargo cargo;
	
	@Fetch(FetchMode.SELECT)
	@ManyToMany(fetch= FetchType.EAGER)
	@JoinTable(
			name="funcionarios_unidades", 
			joinColumns = {@JoinColumn(name = "fk_funcionario")},
			inverseJoinColumns = { @JoinColumn(name = "fk_unidade") }
	)
	private List<UnidadeTrabalho> unidadeTrabalhos = new ArrayList<UnidadeTrabalho>();
	
	public Funcionario() {}


	public Funcionario(String nome, String cpf, BigDecimal salario) {
		this.nome = nome;
		this.cpf = cpf;
		this.salario = salario;
	}


	public Integer getId() {
		return id;
	}


	public String getNome() {
		return nome;
	}


	public String getCpf() {
		return cpf;
	}


	public BigDecimal getSalario() {
		return salario;
	}


	public LocalDate getLocalDate() {
		return dataContratacao;
	}
	

	public void setId(Integer id) {
		this.id = id;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}


	public void setLocalDate(LocalDate localDate) {
		this.dataContratacao = localDate;
	}


	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", salario=" + salario + ", localDate="
				+ dataContratacao + "cargo " + cargo + "Unidades" + unidadeTrabalhos +  "]";
	}


	public Cargo getCargo() {
		return cargo;
	}


	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	
	
	public void adicionarUnidade(UnidadeTrabalho unidadeTrabalho) {
		this.unidadeTrabalhos.add(unidadeTrabalho);
	}
	
	public boolean removerUnidade(UnidadeTrabalho unidadeTrabalho) {
		return this.unidadeTrabalhos.remove(unidadeTrabalho);
	}

	
	
	
	
	
	
}
