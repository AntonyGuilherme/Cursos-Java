package br.com.alura.leilao.util.builder;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;

public class LeilaoBuilder {

	private String nome;
	private BigDecimal valorInicial;
	private Usuario usuario;
	private LocalDate data;
	
	
	public LeilaoBuilder comNome(String nome) {
		this.nome = nome;
		return this;
	}
	
	public LeilaoBuilder comValor(String valor) {
		this.valorInicial = new BigDecimal(valor);
		return this;
	}
	
	public LeilaoBuilder comUsuario(Usuario usuario) {
		this.usuario = usuario;
		return this;
	}
	
	public LeilaoBuilder comData(LocalDate data) {
		this.data = data;
		return this;
	}
	
	public Leilao criar() {
		return new Leilao(
				this.nome,
				this.valorInicial,
				this.data,
				this.usuario
				);
	}
	
}
