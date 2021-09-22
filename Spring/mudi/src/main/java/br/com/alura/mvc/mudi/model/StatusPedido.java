package br.com.alura.mvc.mudi.model;

public enum StatusPedido {

	AGUARDANDO("alert-warning"),
	APROVADO("alert-success"),
	ENTREGUE("alert-dark");
	
	private String classeCSS;
	
	private StatusPedido(String classeCSS) {
		this.classeCSS = classeCSS;
	}
	
	public String getClasseCSS() {
		return this.classeCSS;
	}
	
	
}
