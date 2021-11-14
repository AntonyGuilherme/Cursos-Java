package br.com.alura.escola.infra.email;

import java.util.Properties;

import javax.mail.Session;
import javax.mail.internet.MimeMessage;

import br.com.alura.escola.dominio.aluno.Email;

public class ConfiguracaoEmailBuilder {

	
	public ConfiguracaoDoEnvioDoEmail configurarEmail(String email, String assunto , String conteudo) {
		
		ConfiguracaoDeConexaoDoEmail conexao = new ConfiguracaoDeConexaoDoEmail();
		Session sessaoDeConexaoDoServidorDeEmail = conexao.getConfiguracoesDeConexao();
		
		ConfiguracaoDaMensagemDoEmail configuracaoMensagem = new ConfiguracaoDaMensagemDoEmail(
				sessaoDeConexaoDoServidorDeEmail
				);
		MimeMessage mensagem = configuracaoMensagem.criarMensagem(email, assunto, conteudo);
		
		return new ConfiguracaoDoEnvioDoEmail(sessaoDeConexaoDoServidorDeEmail, mensagem);
		
	}

	
	
	
}
