package br.com.alura.testes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import br.com.alura.conexao.ConexaoFactory;

public class TestaInsercaoComParametro {

	public static void main(String args[]) {

		try (Connection conexao = new ConexaoFactory().getConexao()) {


			// String nome = "Mouse";
			// String descricao = "Mouse sen fio); delete from Produtos;";
			conexao.setAutoCommit(false);

			String query = "INSERT INTO PRODUTO (nome,descricao) " + "VALUES (?,?);";

			try (PreparedStatement statement = conexao.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

				addProduto("SmartTV", "45 polegadas", statement);
				addProduto("PS4", "Modelo 15625", statement);
				conexao.commit();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("ROLLBACK EXECUTADO!");
				conexao.rollback();
			}
			

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	private static void addProduto(String nome, String descricao, PreparedStatement statement) throws SQLException {
		statement.setString(1, nome);
		statement.setString(2, descricao);

		// if(nome.equals("PS4")) throw new RuntimeException("Erro");

		boolean resultado = statement.execute();
		System.out.println(resultado);

		try (ResultSet resultSet = statement.getGeneratedKeys()) {

			while (resultSet.next()) {
				Integer id = resultSet.getInt(1);
				System.out.println(id);
			}

		}

		// if(nome.equals("PS4")) throw new RuntimeException("Erro");

	}

}
