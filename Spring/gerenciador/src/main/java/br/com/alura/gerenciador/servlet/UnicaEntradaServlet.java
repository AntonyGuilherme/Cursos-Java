package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.acao.Executavel;

/**
 * Servlet implementation class UnicaEntradaServlet
 */
@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	
	private static final long serialVersionUID = -6021880244648056981L;

	@Override
	protected void service(
			HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		
		String paramAcao = request.getParameter("acao");
		String nomeDaClasse = "br.com.alura.gerenciador.acao."+paramAcao;
		
		String nome;
		
		try {
			
			Class classe = Class.forName(nomeDaClasse);
			Executavel acao = (Executavel) classe.newInstance();
			nome = acao.executa(request,response);
			
		} catch (ClassNotFoundException | InstantiationException |
				IllegalAccessException | ServletException
				| IOException e) {
			throw new ServletException(e);
		}
		
		
		
		
		String[] redirecionamento =  nome.split(":");
		
		if(redirecionamento[0].equals("forward")) {
			
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("WEB-INF/view/"+redirecionamento[1]);
			requestDispatcher.forward(request, response);
			
		}else {
			
			// redirecionamento client-side
			response.sendRedirect(redirecionamento[1]);
		}
		
		
		
		
	}
	

}
