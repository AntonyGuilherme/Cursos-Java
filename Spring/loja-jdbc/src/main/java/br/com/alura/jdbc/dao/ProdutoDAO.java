package br.com.alura.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.jdbc.modelo.Categoria;
import br.com.alura.jdbc.modelo.Produto;

public class ProdutoDAO {

	private Connection conexao;

	public ProdutoDAO(Connection conexao) {
		this.conexao = conexao;
	}

	public void salvarProduto(Produto produto) {

		String sql = "INSERT INTO PRODUTO (nome,descricao) VALUES (?,?);";

		try (PreparedStatement pstm = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			pstm.setString(1, produto.getNome());
			pstm.setString(2, produto.getDescricao());

			pstm.execute();

			try (ResultSet rst = pstm.getGeneratedKeys()) {

				while (rst.next()) {
					produto.setId(rst.getInt(1));
				}

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public List<Produto> listarProdutos() throws SQLException {
		
		List<Produto> produtos = new ArrayList<Produto>();
		String sql = "Select ID,NOME, DESCRICAO FROM PRODUTO;";
		
		try(PreparedStatement pstm = conexao.prepareStatement(sql)){
			
			pstm.execute();
			
			try(ResultSet rst = pstm.getResultSet()) {
				
				while(rst.next()) {
					produtos.add(new Produto(rst.getInt(1), rst.getString(2),rst.getString(3)));
				}				
				
			}
			
			return produtos;
			
			
		}
		
		
		
		
	}

	public List<Produto> busca(Categoria categoria) throws SQLException {
		
		List<Produto> produtos = new ArrayList<Produto>();
		String sql = "Select ID,NOME, DESCRICAO FROM PRODUTO WHERE CATEGORIA_ID = ?;";
		
		try(PreparedStatement pstm = conexao.prepareStatement(sql)){
			
			pstm.setInt(1, categoria.getId());
			pstm.execute();
			
			try(ResultSet rst = pstm.getResultSet()) {
				
				while(rst.next()) {
					produtos.add(new Produto(rst.getInt(1), rst.getString(2),rst.getString(3)));
				}				
				
			}
			
			return produtos;
			
			
		}
		
		
	}

}
