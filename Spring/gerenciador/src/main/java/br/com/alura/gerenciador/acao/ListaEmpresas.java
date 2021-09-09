package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class ListaEmpresas implements Executavel {
	
	
	public String executa(
			HttpServletRequest request, 
			HttpServletResponse response
			) throws ServletException , IOException {
		
		long antes = System.currentTimeMillis();
		
		System.out.println("Listando empresas");
		
		
		Banco banco = new Banco();
		List<Empresa> lista = banco.getEmpresas();
		request.setAttribute("empresas", new ArrayList<Empresa>(lista));
	
		long depois = System.currentTimeMillis();
		
		System.out.println("Tempo de Execução: "+ (depois-antes));
		
		return "forward:lista-empresas.jsp";
		
	}
	

}
