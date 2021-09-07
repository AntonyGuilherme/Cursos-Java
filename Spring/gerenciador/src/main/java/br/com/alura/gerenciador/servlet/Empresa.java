package br.com.alura.gerenciador.servlet;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

public class Empresa {
	
	private static Integer sequencial = 1;
	private Integer id;
	private String nome;
	private Date dataAbertura = new Date();
	private LocalDateTime dataAberturaLocalDateTime = LocalDateTime.now();
	
	public Empresa(String nome,Integer id) {
		this.setId(id);
		this.setNome(nome);
	}
	
	public Empresa(
			String nome,
			Date dataAbertura 
			) {
		
		this.setId(sequencial);
		this.setNome(nome);
		this.setDataAbertura(dataAbertura);
		Empresa.sequencial++;
	
	}	
	public Integer getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Date getDataAbertura() {
		return dataAbertura;
	}
	
	public LocalDateTime getDataAberturaLocalDateTime() {
		return dataAberturaLocalDateTime;
	}
	
	public void setDataAberturaLocalDateTime(
			LocalDateTime dataAbertLocalDateTime) {
		
		this.dataAberturaLocalDateTime = dataAbertLocalDateTime;
		
		
	}
	
	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	
	
	
	@Override
	public String toString() {
		return String.format(
				"Empresa %s , Identificação : %d",
				this.getNome(),
				this.getId()
				);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empresa other = (Empresa) obj;
		return Objects.equals(id, other.id);
	}
	
	
	

}
