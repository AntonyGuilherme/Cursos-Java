package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MostaEmpresaServelet
 */
@WebServlet("/mostra-empresa")
public class MostaEmpresaServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, 
	 * HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		Banco banco = new Banco();
		Optional<Empresa> optionalEmpresa = banco.getEmpresa(id);
		optionalEmpresa.ifPresentOrElse((Empresa empresa) -> {
			
			try {
			request.setAttribute("empresa", empresa);
			RequestDispatcher rd = request
					.getRequestDispatcher("/form-altera-empresa.jsp");
			rd.forward(request, response);
			}
			catch(Exception execption) {
				System.out.println(execption.getMessage());
			}
			
		}, ()-> {
			throw new NoSuchElementException("Empresa não encontrada!");
		});
		
		
		
	}

	
}
