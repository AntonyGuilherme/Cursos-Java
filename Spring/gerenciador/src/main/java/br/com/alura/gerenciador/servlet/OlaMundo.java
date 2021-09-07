package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//urlPaterns - ajuste na rota
@WebServlet("/oi")
public class OlaMundo extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws IOException{
		
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("Olá Mundo");
		out.println("</body>");
		out.println("</html>");
		
		
		out.close();
		
	}
	

}
