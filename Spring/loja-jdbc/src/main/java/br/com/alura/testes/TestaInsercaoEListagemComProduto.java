package br.com.alura.testes;

import java.sql.Connection;
import java.sql.SQLException;


import br.com.alura.conexao.ConexaoFactory;
import br.com.alura.jdbc.dao.ProdutoDAO;
import br.com.alura.jdbc.modelo.Produto;

public class TestaInsercaoEListagemComProduto {

	public static void main(String args[]) {
		
		Produto produto = new Produto("Cômoda","Cômoda Vertical");
		
		try(Connection conexao = new ConexaoFactory().getConexao() ) {
			
			ProdutoDAO persistenciaProduto = new ProdutoDAO(conexao);
			persistenciaProduto.salvarProduto(produto);
			
			persistenciaProduto.listarProdutos().forEach(System.out::println);
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
