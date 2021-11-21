package br.com.alura.escola.academico.dominio.eventos;

import java.time.LocalDateTime;
import java.util.Map;

import br.com.alura.escola.shared.dominio.CPF;
import br.com.alura.escola.shared.dominio.evento.Evento;
import br.com.alura.escola.shared.dominio.evento.TipoEvento;

public class AlunoMatriculado implements Evento {

	private final CPF cpfDoAluno;
	private final LocalDateTime momento;

	public AlunoMatriculado(CPF cpfDoAluno) {

		this.cpfDoAluno = cpfDoAluno;
		this.momento = LocalDateTime.now();
	}

	public String getCpf() {

		return this.cpfDoAluno.getCpf();
	}

	@Override
	public LocalDateTime momento() {

		return this.momento;
	}

	@Override
	public TipoEvento getTipoDoEvento() {
		
		return TipoEvento.ALUNO_MATRICULADO;
	}

	@Override
	public Map<String, Object> informacoes() {

		return Map.of("cpf",this.cpfDoAluno);
	}

}
