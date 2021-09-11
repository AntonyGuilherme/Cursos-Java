package br.com.alura.testes;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;


import br.com.alura.conexao.ConexaoFactory;

public class TestaConexao {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		try(Connection conexao = new ConexaoFactory().getConexao()){
			
			System.out.println("Sucesso na conexão");
			
			
		}catch (SQLException e) {
			
			System.out.println(e.getMessage());
			
			
		}finally {
			
			System.out.println("Fim");
			
		};
		
	}

}
