package br.com.alura.gerenciador.modelo;

public class Usuario {
	
	
	private String login;
	private String senha;
	
	public Usuario(String login,String senha) {
		this.setLogin(login);
		this.setSenha(senha);
	}
	
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		Usuario usuario = (Usuario) obj;
		
		return this.login.equals(usuario.getLogin()) 
				&& this.senha.equals(usuario.getSenha());
		
	}
	
	@Override
	public String toString() {
		
		return String.format("Nome de Usuário : %s", this.getLogin());
		
	}
	
	
	

}
