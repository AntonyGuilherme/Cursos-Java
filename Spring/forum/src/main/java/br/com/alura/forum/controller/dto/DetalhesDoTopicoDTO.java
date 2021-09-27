package br.com.alura.forum.controller.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import br.com.alura.forum.modelo.StatusTopico;
import br.com.alura.forum.modelo.Topico;

public class DetalhesDoTopicoDTO extends TopicoDTO {

	
	public DetalhesDoTopicoDTO(Topico topico) {
		super(topico);
		
		this.nomeAutor = topico.getAutor().getNome();
		this.status = topico.getStatus();
		Stream<RespostaDTO> streamDTO = topico.getRespostas().stream().map(RespostaDTO::new);
		this.respostas = streamDTO.collect(Collectors.toList());
		this.dataCriacao = topico.getDataCriacao();
		
		
	}
	
	private LocalDateTime dataCriacao;
	private String nomeAutor;
	private StatusTopico status;
	private List<RespostaDTO> respostas;
	
	
	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}
	public String getNomeAutor() {
		return nomeAutor;
	}
	public StatusTopico getStatus() {
		return status;
	}
	public List<RespostaDTO> getRespostas() {
		return respostas;
	}
	
	
	
	
	
}
