package br.com.alura.testes;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.alura.conexao.ConexaoFactory;

public class TestaListagem {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub	
		
		try(Connection conexao = new ConexaoFactory().getConexao()){
			
			System.out.println("Sucesso na conexão");
			
			String query = "SELECT ID , NOME , DESCRICAO FROM PRODUTO;";
			PreparedStatement statement = conexao.prepareStatement(query);
			boolean resultado = statement.execute();
			System.out.println(resultado);
			
			ResultSet resultSet = statement.getResultSet();
			
			while(resultSet.next()) {
				Integer id = resultSet.getInt("ID");
				String nome = resultSet.getString("NOME");
				String descricao = resultSet.getString("DESCRICAO");
				
				System.out.format(
						"ID : %d NOME : %s DESCRICAO : %s \n", 
						id,nome,descricao
						);
				
			}
			
			
		}catch (SQLException e) {
			
			System.out.println(e.getMessage());
			
			
		}finally {
			
			System.out.println("Fim");
			
		};
		
	}

}
