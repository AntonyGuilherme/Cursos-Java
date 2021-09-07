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
 * Servlet implementation class AlteraEmpresaServlet
 */
@WebServlet("/altera-empresa")
public class AlteraEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse 
	 * response)
	 */
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		System.out.print("Alterando a empresa");
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		String nomeEmpresa = request.getParameter("nome");
		String dataEmpresa = request.getParameter("data");
		
		try {
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date dataAbertura = sdf.parse(dataEmpresa);
			
			Banco banco = new Banco();
			Empresa empresa = banco.getEmpresa(id).get();
			empresa.setNome(nomeEmpresa);
			empresa.setDataAbertura(dataAbertura);
			
			response.sendRedirect("lista-empresas");
			
		}
		catch(ParseException exception) {
			throw new ServletException(exception);
		}
		
		
	}

}
