package br.com.alura.escola.infra.aluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.com.alura.escola.dominio.aluno.Aluno;
import br.com.alura.escola.dominio.aluno.CPF;
import br.com.alura.escola.dominio.aluno.RepositorioDeAlunos;
import br.com.alura.escola.dominio.aluno.Telefone;

public class RepositorioDeAlunosComJDBC implements RepositorioDeAlunos {

	private Connection connection;

	public RepositorioDeAlunosComJDBC(Connection connection) {

		this.connection = connection;

	}

	@Override
	public void matricular(Aluno aluno) {
		try {
			
			String sqlMatricula = "INSERT INTO ALUNO VALUES(?,?,?);";
			PreparedStatement ps = this.connection.prepareStatement(sqlMatricula);
			ps.setString(1, aluno.getCPF());
			ps.setString(2, aluno.getNome());
			ps.setString(3, aluno.getEmail());
			ps.execute();
			
			String sqlTelefone = "INSERT INTO TELEFONE VALUES(?,?)";
			PreparedStatement psTelefone = this.connection.prepareStatement(sqlTelefone);
			
			aluno.getTelefones()
			.forEach((telefone) -> this.inserirTelefone(telefone, psTelefone));
			
			
			

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private void inserirTelefone(Telefone telefone,PreparedStatement ps) {
		
		try {
			
			ps.setString(0, telefone.getDDD());
			ps.setString(1, telefone.getNumero());
			ps.execute();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	@Override
	public Aluno buscarPorCPF(CPF cpf) {
		return null;
	}

	@Override
	public List<Aluno> listarTodosAlunosMatriculados() {
		return null;
	}

}
