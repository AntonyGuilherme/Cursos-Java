package br.com.alura.forum.controller.dto;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;

import br.com.alura.forum.modelo.Topico;

public class TopicoDTO {

	private Long id;
	private String tiutlo;
	private String mensagem;
	private LocalDateTime dataCriacao;
	
	public TopicoDTO(Topico topico) {
		
		this.id = topico.getId();
		this.tiutlo = topico.getTitulo();
		this.mensagem = topico.getMensagem();
		this.dataCriacao = topico.getDataCriacao();
		
	}
	
	
	public Long getId() {
		return id;
	}
	public String getTiutlo() {
		return tiutlo;
	}
	public String getMensagem() {
		return mensagem;
	}
	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}


	public static Page<TopicoDTO> converterTopicos(Page<Topico> topicos) {
		
		return topicos.map(TopicoDTO::new);
	}
	
	
	
	
}
