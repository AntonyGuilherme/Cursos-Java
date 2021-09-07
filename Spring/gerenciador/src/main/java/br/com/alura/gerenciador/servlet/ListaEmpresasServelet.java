package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListaEmpresasServelet
 * loadOnStartUp é instanciado assim que o servidor é iniciado
 */
@WebServlet("/lista-empresas")
public class ListaEmpresasServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	public ListaEmpresasServelet() {
		System.out.print("Lista de empresas inciado!");
	}
	
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, 
	 * HttpServletResponse response)
	 */
	protected void service(
			HttpServletRequest request, 
			HttpServletResponse response
			) throws ServletException, IOException {
		
		Banco banco = new Banco();
		List<Empresa> lista = banco.getEmpresas();
		
		RequestDispatcher requestDispatcher = request
				.getRequestDispatcher("/lista-empresas.jsp");
		
		request.setAttribute("empresas", new ArrayList<Empresa>(lista));
		requestDispatcher.forward(request, response);
		
	}

}
