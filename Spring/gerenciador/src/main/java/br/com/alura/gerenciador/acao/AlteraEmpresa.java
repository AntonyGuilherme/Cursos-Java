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

public class AlteraEmpresa implements Executavel {
	
	
	public String executa(
			HttpServletRequest request, 
			HttpServletResponse response
			) throws ServletException , IOException {
		
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		String nomeEmpresa = request.getParameter("nome");
		String dataEmpresa = request.getParameter("data");
		
		System.out.format("Altera empresa %s",paramId);
		
		try {
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date dataAbertura = sdf.parse(dataEmpresa);
			
			Banco banco = new Banco();
			Empresa empresa = banco.getEmpresa(id).get();
			empresa.setNome(nomeEmpresa);
			empresa.setDataAbertura(dataAbertura);
			
			return "redirect:entrada?acao=ListaEmpresas";
			
		}
		catch(ParseException exception) {
			throw new ServletException(exception);
		}
		
	}
	

}
