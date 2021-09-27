package br.com.alura.forum.controller.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.alura.forum.modelo.Topico;

public class AtualizacaoTopicoForm {
	
	@NotNull @NotBlank @Length(min = 5)
	private String titulo;
	
	@NotNull @NotEmpty
	private String mensagem;
	
	
	public String getMensagem() {
		return mensagem;
	}
	public String getTitulo() {
		return this.titulo;
	}
	
	
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public Topico atualizar(Long Id,Topico topico) {
		
		topico.setTitulo(this.getTitulo());
		topico.setMensagem(this.getMensagem());
		
		return topico;
	
	}

}
