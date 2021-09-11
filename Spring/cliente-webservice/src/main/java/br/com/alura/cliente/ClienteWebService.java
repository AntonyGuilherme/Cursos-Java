package br.com.alura.cliente;

import java.io.IOException;


import org.apache.http.client.fluent.Request;

public class ClienteWebService {
	
	
	public static void main(String[] args) {
		
		try {
		
		String conteudo =	Request
			.Post("http://localhost:8080/gerenciador/empresas")
			.addHeader("Accept","application/json")
			.execute()
			.returnContent()
			.asString();
		
		System.out.println(conteudo);
		
		} 
		catch (IOException exception) {
			System.out.println(exception.getMessage());
		}
		
	}
	

}
