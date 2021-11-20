package br.com.alura.escola.academico.dominio.eventos;

import java.time.format.DateTimeFormatter;

public class LogDeAlunoMatriculado extends Ouvinte {
	

	@Override
	protected void reageAo(Evento evento) {
		
		DateTimeFormatter formatoDaData = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		String momentoFomatado = evento.momento().format(formatoDaData);
		
		System.out.format(
				"Aluno com CPF %s matriculado em: %s \n",
				((AlunoMatriculado) evento).getCpf(),
				momentoFomatado
				);
		
	}
	

	@Override
	protected Boolean deveProcessar(Evento evento) {
		
		return evento instanceof AlunoMatriculado;
	}
	
	

}
