package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class NovaEmpresa implements Executavel {
	
	public String executa(
			HttpServletRequest request, 
			HttpServletResponse response
			) throws ServletException , IOException {
		
		// sempre retorna uma string
				String nome = request.getParameter("nome");
				String data = request.getParameter("data");
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				
				
				try {
					
					Date dataAbertura = sdf.parse(data);
					Empresa empresa = new Empresa(nome,dataAbertura);
					Banco banco = new Banco();
					banco.adiciona(empresa);
					
					// redirecionamento client-side
					return "redirect:entrada?acao=lista-empresas";
					
					
				} catch (ParseException e) {
					throw new ServletException(e);
				}

}
	}
	
