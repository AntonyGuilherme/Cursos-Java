package br.com.alura.conexao;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import br.com.alura.conexao.modelo.PropriedadesConexaoException;

public class ConexaoFactoryPropriedades {
	
	private final String PATH = "src/main/resources/database.config.properties";
	private final String url;
	private final String usuario;
	private final String senha;
	
	public ConexaoFactoryPropriedades() {
		
		try(FileReader fileReader = new FileReader(PATH)) {
			
			Properties propriedadesBancoConexao = new Properties();
			propriedadesBancoConexao.load(fileReader);
			this.url = propriedadesBancoConexao.getProperty("url");
			this.usuario = propriedadesBancoConexao.getProperty("user");
			this.senha = propriedadesBancoConexao.getProperty("password");
		
		}catch(IOException exception) {
			throw new PropriedadesConexaoException(exception);
		}
		
	}
	
	
	public String getUrl() {
		return url;
	}
	
	public String getUsuario() {
		return usuario;
	}
	
	public String getSenha() {
		return senha;
	}
	
	
	

}
