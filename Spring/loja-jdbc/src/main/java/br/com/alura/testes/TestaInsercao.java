package br.com.alura.testes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import br.com.alura.conexao.ConexaoFactory;

public class TestaInsercao {
	
	public static void main(String[] args) {
		
		try(Connection conexao = new ConexaoFactory().getConexao()) {
	
			Statement statement = conexao.createStatement();
			
			String query = "INSERT INTO PRODUTO (nome,descricao) "
					+ "VALUES ('Mouse','Mouse sem fio');";
			
			// true se é uma lista de dados
			// false para o contrário como updates ou deletes
			boolean resultado = statement.execute(
					query,Statement.RETURN_GENERATED_KEYS);
			System.out.println(resultado);
			
			ResultSet resultSet = statement.getGeneratedKeys();
			
			while(resultSet.next()) {
				Integer id = resultSet.getInt(1);
				System.out.println(id);
			}
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}

}
