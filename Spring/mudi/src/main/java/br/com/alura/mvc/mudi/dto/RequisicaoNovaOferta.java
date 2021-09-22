package br.com.alura.mvc.mudi.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import br.com.alura.mvc.mudi.model.Oferta;

public class RequisicaoNovaOferta {

	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private Long pedidoId;
	
	@Pattern(regexp = "^\\d+(\\.\\d+{2})?$")
	@NotNull
	private String valor;
	
	@Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$")
	@NotNull
	private String dataDaEntrega;
	
	private String comentario;

	public Long getPedidoId() {
		return pedidoId;
	}

	public String getValor() {
		return valor;
	}

	public String getDataDaEntrega() {
		return dataDaEntrega;
	}

	public String getComentario() {
		return comentario;
	}

	public void setPedidoId(Long pedidoId) {
		this.pedidoId = pedidoId;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public void setDataDaEntrega(String dataDaEntrega) {
		this.dataDaEntrega = dataDaEntrega;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Oferta toOferta() {
		
		return new Oferta(
				new BigDecimal(this.valor),
				LocalDate.parse(this.dataDaEntrega,formatter),
				this.comentario);
			
		
	}
	
	
	
	
}
