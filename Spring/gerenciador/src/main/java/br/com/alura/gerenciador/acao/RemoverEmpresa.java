package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.util.NoSuchElementException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;

public class RemoverEmpresa implements Executavel {
	
	public String executa(
			HttpServletRequest request, 
			HttpServletResponse response
			) throws ServletException , IOException {
		
		try {
			
			Integer id = Integer.parseInt(request.getParameter("id"));
			Banco banco = new Banco();
			
			System.out.println(id);
			
			banco.deletarEmpresa(id);
			
	
			return "redirect:entrada?acao=ListaEmpresas";
		
		}catch (NoSuchElementException noSuchElementException) {
			
			throw new ServletException(noSuchElementException);
			
		}
		
	}
	

}
