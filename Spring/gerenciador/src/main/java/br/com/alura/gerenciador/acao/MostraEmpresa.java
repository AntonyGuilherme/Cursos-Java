package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class MostraEmpresa implements Executavel {
	
	public String executa(
			HttpServletRequest request, 
			HttpServletResponse response
			) throws ServletException , IOException {
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		Banco banco = new Banco();
		Optional<Empresa> optionalEmpresa = banco.getEmpresa(id);
		optionalEmpresa.ifPresentOrElse((Empresa empresa) -> {
			
			try {
			request.setAttribute("empresa", empresa);
			}
			catch(Exception execption) {
				System.out.println(execption.getMessage());
			}
			
		}, ()-> {
			throw new NoSuchElementException("Empresa não encontrada!");
		});
		
		
		return "forward:form-altera-empresa.jsp";
	}
	

}
