package br.com.alura.forum.controller.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class TokenDTO {

	
	private String token;
	private String tipo;
	private Collection< ? extends GrantedAuthority> perfis;
	private String nomeDeUsuario;
	
	
	public TokenDTO(
			String token, 
			String tipo, 
			Collection<? extends GrantedAuthority> perfis, 
			String nomeDeUsuario) {
		
		this.token = token;
		this.tipo = tipo;
		this.perfis = perfis;
		this.nomeDeUsuario = nomeDeUsuario;
	}


	public String getToken() {
		return token;
	}


	public String getTipo() {
		return tipo;
	}


	public Collection<? extends GrantedAuthority> getPerfis() {
		return perfis;
	}


	public String getNomeDeUsuario() {
		return nomeDeUsuario;
	}
	
	
	
	
	
	
	
}
