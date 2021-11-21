package br.com.alura.escola.academico.infra.aluno;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.alura.escola.academico.dominio.aluno.Aluno;
import br.com.alura.escola.academico.dominio.aluno.RepositorioDeAlunos;
import br.com.alura.escola.academico.dominio.aluno.excessoes.AlunoNaoEncontrado;
import br.com.alura.escola.shared.dominio.CPF;

public class RepositorioDeAlunoEmMemoria implements RepositorioDeAlunos {

	private List<Aluno> matriculados = new ArrayList<Aluno>();
	
	@Override
	public void matricular(Aluno aluno) {
		
		this.matriculados.add(aluno);
	}

	@Override
	public Aluno buscarPorCPF(CPF cpf) {
		
		String numeroDoCpf = cpf.getCpf();
		
		return this.matriculados.stream()
				.filter((aluno) -> aluno.getNumeroDoCPF().equals(numeroDoCpf))
				.findFirst()
				.orElseThrow(() -> new AlunoNaoEncontrado(numeroDoCpf));
	}

	@Override
	public List<Aluno> listarTodosAlunosMatriculados() {

		return Collections.unmodifiableList(this.matriculados);
	}

}
