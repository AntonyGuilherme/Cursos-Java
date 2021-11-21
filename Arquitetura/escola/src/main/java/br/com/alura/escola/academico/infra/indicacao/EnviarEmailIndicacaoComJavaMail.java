package br.com.alura.escola.academico.infra.indicacao;

import javax.mail.MessagingException;

import br.com.alura.escola.academico.aplicacao.indicacao.EnviarEmailIndicacao;
import br.com.alura.escola.academico.dominio.aluno.Aluno;
import br.com.alura.escola.academico.infra.email.ConfiguracaoDoEnvioDoEmail;
import br.com.alura.escola.academico.infra.email.ConfiguracaoEmailBuilder;

public class EnviarEmailIndicacaoComJavaMail implements EnviarEmailIndicacao {


	@Override
	public void enviarPara(Aluno indicado) {
		
		ConfiguracaoEmailBuilder configuracaoDoEmail = new ConfiguracaoEmailBuilder();
		
		try(ConfiguracaoDoEnvioDoEmail configuracaoDoEnvioDoEmail = configuracaoDoEmail
				.configurarEmail(indicado.getEmail(), "Aluno Indicado", "indicacao")){
			
			configuracaoDoEnvioDoEmail.enviarEmail();	
			
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		

	}





}
