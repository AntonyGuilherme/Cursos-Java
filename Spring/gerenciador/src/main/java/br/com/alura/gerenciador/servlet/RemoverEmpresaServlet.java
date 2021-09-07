package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.util.NoSuchElementException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RemoverEmpresaServlet
 */
@WebServlet( "/remover-empresa")
public class RemoverEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoverEmpresaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		
		try {
		
			Integer id = Integer.parseInt(req.getParameter("id"));
			Banco banco = new Banco();
			
			System.out.println(id);
			
			banco.deletarEmpresa(id);
			
		
			// redirecionamento client-side
			resp.sendRedirect("lista-empresas");
		
		}catch (NoSuchElementException noSuchElementException) {
			
			throw new ServletException(noSuchElementException);
			
		}
		
		
	}
	

}
