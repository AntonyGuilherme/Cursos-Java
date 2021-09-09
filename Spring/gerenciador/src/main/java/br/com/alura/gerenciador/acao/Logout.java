package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout implements Executavel {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession sessao = request.getSession();
		//sessao.removeAttribute("usuarioLogado");
		// remove completamente a sessão : cokies e atributos
		sessao.invalidate(); 
		
		return "redirect:entrada?acao=LoginForm";
	}

}
