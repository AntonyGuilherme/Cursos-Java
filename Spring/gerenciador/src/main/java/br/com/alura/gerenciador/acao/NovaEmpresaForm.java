package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class NovaEmpresaForm implements Executavel {
	
	public String executa(
			HttpServletRequest request, 
			HttpServletResponse response
			) throws ServletException , IOException {
		
		return "forward:form-nova-empresa.jsp";

		}
	

}
