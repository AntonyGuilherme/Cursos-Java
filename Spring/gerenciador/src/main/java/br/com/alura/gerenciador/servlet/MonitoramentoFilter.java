package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


//@WebFilter("/entrada")
public class MonitoramentoFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}
	
	@Override
	public void destroy() {}
	
	@Override
	public void doFilter(
			ServletRequest request, 
			ServletResponse response, 
			FilterChain chain
			) throws IOException, ServletException {
		
		System.out.println("Monitoramento");
		
		long antes = System.currentTimeMillis();
		
		//executa a requisição
		chain.doFilter(request, response);
	
		long depois = System.currentTimeMillis();
		
		System.out.format(
			"Tempo de Execução: %d Recurso %s \n",
			(depois-antes),
			request.getParameter("acao")
		);
		
	}

	
	
}
