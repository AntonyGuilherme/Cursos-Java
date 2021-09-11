package br.com.alura.testes;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.alura.conexao.ConexaoFactory;

public class TestaPoolConexoes {

	public static void main(String args[]) {
		
			
			
			for(int i =0 ; i < 20; i++) {
				
				
				try {
					Connection conexao = new ConexaoFactory().getConexao();
					System.out.println("Conexao "+ i);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
			
			
		
	}
	
	
}
