package br.com.alura.escola.infra.indicacao;

import javax.mail.MessagingException;


import br.com.alura.escola.aplicacao.indicacao.EnviarEmailIndicacao;
import br.com.alura.escola.dominio.aluno.Aluno;
import br.com.alura.escola.infra.email.ConfiguracaoDoEnvioDoEmail;
import br.com.alura.escola.infra.email.ConfiguracaoEmailBuilder;

public class EnviarEmailIndicacaoComJavaMail implements EnviarEmailIndicacao {


	@Override
	public void enviarPara(Aluno indicado) {

		String assunto = "Email para launo";
		String corpo = "Teste";
		
		ConfiguracaoEmailBuilder configuracaoDoEmail = new ConfiguracaoEmailBuilder();
		
		try(ConfiguracaoDoEnvioDoEmail configuracaoDoEnvioDoEmail = configuracaoDoEmail
				.configurarEmail(indicado.getEmail(), "Aluno Indicado", "indicacao")){
			
			configuracaoDoEnvioDoEmail.enviarEmail();	
			
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		

	}





}
