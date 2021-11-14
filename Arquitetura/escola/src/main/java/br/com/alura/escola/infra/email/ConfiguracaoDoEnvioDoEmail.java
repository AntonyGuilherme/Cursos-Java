package br.com.alura.escola.infra.email;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;


public class ConfiguracaoDoEnvioDoEmail implements AutoCloseable {

	static final String SMTP_USERNAME = "<username OCID from SMTP credentials>";
	static final String SMTP_PASSWORD = "<SMTP password>";
	static final String HOST = "<SMTP endpoint>";
	MimeMessage mensagem;
	Transport servicoDeEnvio;
	Session sessaoDeConexaoComServidor;
	
	public ConfiguracaoDoEnvioDoEmail(
			Session sessaoDeConexaoComServidor,
			MimeMessage mensagem
			) {
		
				this.sessaoDeConexaoComServidor = sessaoDeConexaoComServidor;
				this.mensagem = mensagem;
	
	}
	
	
	public void enviarEmail() {
		

		try {
			
			this.servicoDeEnvio = this.sessaoDeConexaoComServidor.getTransport();
			this.servicoDeEnvio.connect(HOST, SMTP_USERNAME, SMTP_PASSWORD);
			this.servicoDeEnvio.sendMessage(this.mensagem, this.mensagem.getAllRecipients());

		}

		catch (Exception ex) {
		
			throw new RuntimeException(ex);
		}

		
	}


	@Override
	public void close() throws MessagingException  {
		
		this.servicoDeEnvio.close();
		
	}
	
	
	
}
