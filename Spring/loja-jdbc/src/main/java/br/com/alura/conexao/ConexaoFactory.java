package br.com.alura.conexao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;


public class ConexaoFactory {
	
	private DataSource dataSource;
	
	
	public ConexaoFactory() {
			
			ConexaoFactoryPropriedades propriedades = new ConexaoFactoryPropriedades();
		
			ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
			comboPooledDataSource.setJdbcUrl(propriedades.getUrl());
			comboPooledDataSource.setUser(propriedades.getUsuario());
			comboPooledDataSource.setPassword(propriedades.getSenha());
			
			comboPooledDataSource.setMaxPoolSize(15);
			
			
			this.dataSource = comboPooledDataSource;
			
		
	}
	
	public Connection getConexao() throws SQLException {
		return this.dataSource.getConnection();
	}

	
	
	

}
