package br.com.alura.escola.infra.email;

import java.io.UnsupportedEncodingException;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.management.RuntimeErrorException;

import br.com.alura.escola.dominio.aluno.Email;

public class ConfiguracaoDaMensagemDoEmail {

	MimeMessage mensagem;
	private final String ENDERECO_DE_EMAIL = "email";
	private final String IDENTIFICADOR_DA_APLICACAO = "nome";

	public ConfiguracaoDaMensagemDoEmail(Session sessaoDeConexaoDoServidorDeEmail) {

		this.mensagem = new MimeMessage(sessaoDeConexaoDoServidorDeEmail);

	}

	private ConfiguracaoDaMensagemDoEmail configurarRemetente() {

		try {

			InternetAddress enderecoDeEmail = new InternetAddress(this.ENDERECO_DE_EMAIL,
					this.IDENTIFICADOR_DA_APLICACAO);
			this.mensagem.setFrom(enderecoDeEmail);

		} catch (UnsupportedEncodingException | MessagingException e) {

			throw new RuntimeException("Erro ao montar a mensagem");
		}

		return this;
	}

	private ConfiguracaoDaMensagemDoEmail configurarDestinatario(String email) {
		
		try {
			
			this.mensagem.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
			
		} catch (AddressException e) {
			
			throw new RuntimeException("erro ao montar o endereco do destinatario");

		} catch (MessagingException e) {
			
			throw new RuntimeException("erro ao montar a mensagem");
		}
		
		return this;
		
	}
	
	private ConfiguracaoDaMensagemDoEmail informarAssunto(String assunto) {
		
		try {
			this.mensagem.setSubject(assunto);
		} catch (MessagingException e) {
			throw new RuntimeException("Erro ao informar o assunto");
		}
		
		return this;
		
	}
	
	private ConfiguracaoDaMensagemDoEmail informarConteudo(String conteudo) {
		
		try {
			this.mensagem.setContent(conteudo, "text/html");
		} catch (MessagingException e) {
			throw new RuntimeException("Erro ao informar o conteudo");
		}
		
		return this;
		
	}
	

	public MimeMessage criarMensagem(String email, String assunto, String conteudo) {
		
		this.configurarRemetente()
		.configurarDestinatario(email)
		.informarAssunto(assunto)
		.informarConteudo(conteudo);
		
		return this.mensagem;
	}

}
