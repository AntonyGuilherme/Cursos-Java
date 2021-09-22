package br.com.alura.mvc.mudi.interceptor;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;


public class InterceptadorDeAcessos implements HandlerInterceptor{
	
	private static List<Acesso> acessos = new ArrayList<>();
	
	public static List<Acesso> getAcessos(){
		return acessos;
	}

	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		Acesso acesso = new Acesso();
		acesso.path = request.getRequestURI();
		acesso.data = LocalDateTime.now();
		
		request.setAttribute("acesso", acesso);
		
		return true;
		
	}
	
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		Acesso acesso = (Acesso) request.getAttribute("acesso");
		acesso.duracao = Duration.between(acesso.data,LocalDateTime.now());
		
		acessos.add(acesso);
		
	}
	
	
	
	public static class Acesso{
		
		private String path;
		private LocalDateTime data;
		private Duration duracao;
		
		
		public String getPath() {
			return path;
		}


		public LocalDateTime getData() {
			return data;
		}


		public Duration getDuracao() {
			return duracao;
		}


		public void setPath(String path) {
			this.path = path;
		}


		public void setData(LocalDateTime data) {
			this.data = data;
		}


		public void setDuracao(Duration duracao) {
			this.duracao = duracao;
		}


		@Override
		public String toString() {
			return String.format("Acesso [path=%s, data=%s, duracao=%s]", path, data, duracao);
		}
		
		
		
		
		
	}
	
	

}
