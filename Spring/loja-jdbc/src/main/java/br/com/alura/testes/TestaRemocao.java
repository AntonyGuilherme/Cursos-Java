package br.com.alura.testes;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.com.alura.conexao.ConexaoFactory;

public class TestaRemocao {
	
	
	public static void main(String[] args) {
		
	
		try(Connection conexao = new ConexaoFactory().getConexao()){
			
			
			String query = "DELETE FROM PRODUTO WHERE ID > ?";
			PreparedStatement stm = conexao.prepareStatement(query);
			stm.setInt(1, 2);
			stm.execute();
			System.out.format("%d Linhas Modidficadas!\n",stm.getUpdateCount());
			
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
		
	}
	

}
