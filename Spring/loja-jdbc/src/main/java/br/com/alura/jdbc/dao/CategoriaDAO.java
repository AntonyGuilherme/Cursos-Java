package br.com.alura.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.jdbc.modelo.Categoria;
import br.com.alura.jdbc.modelo.Produto;

public class CategoriaDAO {
	
	
	private Connection conexao;
	
	
	public CategoriaDAO(Connection conexao){
		this.conexao = conexao;
	}
	
	public List<Categoria> listar() throws SQLException{
		
		List<Categoria> categorias = new ArrayList<>();
		
		String sql = "SELECT ID,NOME FROM CATEGORIA;";
		
		try(PreparedStatement pstm = conexao.prepareStatement(sql)){
			
			pstm.execute();
			
			try(ResultSet rst = pstm.getResultSet()){
				
				while(rst.next()) {
					categorias.add(new Categoria(rst.getInt(1),rst.getString(2)));
				}
				
				return categorias;
				
			}
			
		} 
		
		
	}

	public List<Categoria> listarComProdutos() throws SQLException {
		
		List<Categoria> categorias = new ArrayList<>();
		
		String sql = "SELECT C.* , P.* FROM CATEGORIA C "
				+ "INNER JOIN PRODUTO P ON P.CATEGORIA_ID = C.ID;";
		
		try(PreparedStatement pstm = conexao.prepareStatement(sql)){
			
			pstm.execute();
			
			try(ResultSet rst = pstm.getResultSet()){
				
				while(rst.next()) {
					
					Categoria categoria = new Categoria(rst.getInt(1),rst.getString(2));
					
					int index = categorias.indexOf(categoria);
					
					if( index >= 0 ) {
						categoria = categorias.get(index);
					}else {
						categorias.add(categoria);						
					}
					
					categoria.adicionarProduto(new Produto(rst.getInt(3),rst.getString(4),rst.getString(5)));
					
				}
				
				return categorias;
				
			}
			
		} 
	}
	

}
