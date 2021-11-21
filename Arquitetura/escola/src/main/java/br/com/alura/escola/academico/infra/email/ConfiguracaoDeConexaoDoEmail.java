package br.com.alura.escola.academico.infra.email;

import java.util.Properties;

import javax.mail.Session;

public class ConfiguracaoDeConexaoDoEmail {

	static final int PORT = 587;
	Properties propriedadeDeConexao;


	public ConfiguracaoDeConexaoDoEmail() {
		this.propriedadeDeConexao = System.getProperties();
	}
	
	
	private ConfiguracaoDeConexaoDoEmail configurarProtocolo() {
		
		this.propriedadeDeConexao.put("mail.transport.protocol", "smtp");
		
		return this;
	}
	
	private ConfiguracaoDeConexaoDoEmail configurarPortaDoServidor() {
		
		this.propriedadeDeConexao.put("mail.smtp.port", PORT);
		
		return this;
	}
	
	private ConfiguracaoDeConexaoDoEmail ativarSSL() {
		
		this.propriedadeDeConexao.put("mail.smtp.ssl.enable", "true"); 
		
		return this;
	}

	private Session criarSessaoComAsConfiguracoes() {
		return Session.getDefaultInstance(this.propriedadeDeConexao);
	}
	
	public Session getConfiguracoesDeConexao() {
		
		return this.configurarPortaDoServidor()
		.configurarProtocolo()
		.ativarSSL()
		.criarSessaoComAsConfiguracoes();
		
	}

}
