package br.com.alura.escola.academico.infra.email;

import javax.mail.Session;
import javax.mail.internet.MimeMessage;


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
