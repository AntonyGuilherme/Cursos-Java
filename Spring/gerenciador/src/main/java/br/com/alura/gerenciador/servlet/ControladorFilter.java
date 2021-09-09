package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.acao.Executavel;


public class ControladorFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}
	
	@Override
	public void destroy() {}
	
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(
			ServletRequest servletRequest,
			ServletResponse servletResponse, 
			FilterChain chain
			) throws IOException, ServletException {
	
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
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
