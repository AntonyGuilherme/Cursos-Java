package br.com.alura.testes;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.alura.conexao.ConexaoFactory;
import br.com.alura.jdbc.dao.CategoriaDAO;
import br.com.alura.jdbc.modelo.Categoria;


public class TestaListagemCategorias {

	public static void main(String[] args) {
		
		try(Connection conexao = new ConexaoFactory().getConexao()) {
					
			CategoriaDAO categoriaDAO = new CategoriaDAO(conexao);
			List<Categoria> listaDeCategorias = categoriaDAO.listarComProdutos();
			
			listaDeCategorias
			.stream()
			.forEach(System.out::println);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
