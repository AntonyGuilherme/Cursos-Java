package br.com.alura.forum.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name="perfis")
public class Perfil implements GrantedAuthority {

	
	private static final long serialVersionUID = 3090441623057409360L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	
	public Perfil() {}


	public Long getId() {
		return id;
	}


	public String getNome() {
		return nome;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	@Override
	public String getAuthority() {
		return this.nome;
	}
	
	
	
	
}
