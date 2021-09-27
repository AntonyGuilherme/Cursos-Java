package br.com.alura.forum.config.dto;

public class ErroDeFormularioDTO {

	private String campo;
	private String erro;
	
	
	public ErroDeFormularioDTO(String campo, String erro) {
		super();
		this.campo = campo;
		this.erro = erro;
	}
	
	
	public String getCampo() {
		return campo;
	}
	public String getErro() {
		return erro;
	}

	
	
}
