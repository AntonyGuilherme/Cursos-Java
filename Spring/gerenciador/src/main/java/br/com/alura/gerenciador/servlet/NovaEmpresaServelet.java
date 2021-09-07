package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NovaEmpresaServelet
 */
@WebServlet("/nova-empresa")
public class NovaEmpresaServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, 
	 * HttpServletResponse response)
	 * aceita somente requisições post
	 */
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		System.out.print("Cadastrando uma nova empresa");
		
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
			response.sendRedirect("lista-empresas");
			
			
			//chamando o JSP
			/* Redirecionamento Server-Side
			 RequestDispatcher requestDispatcher = request
			.getRequestDispatcher("/lista-empresas");
			request.setAttribute("empresa",empresa);
			*/
			//requestDispatcher.forward(request, response);
			
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		
		
	}
	
}
