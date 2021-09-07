package br.com.alura.gerenciador.servlet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Banco {
	
	
	private static List<Empresa> empresas = new ArrayList<>();
	
	static {
		
		Empresa empresa = new Empresa("Alura",42);
		Empresa empresa2 = new Empresa("Caelum",84);
		
		empresas.add(empresa);
		empresas.add(empresa2);
		
	}
	

	public void adiciona(Empresa empresa) {
		empresas.add(empresa);
	}
	
	public List<Empresa> getEmpresas(){
		return Collections.unmodifiableList(Banco.empresas);
	}

	public boolean deletarEmpresa(Integer id) {
		
		return empresas.removeIf((empresa) -> empresa.getId() == id);
		
		//procurando a empresa na lista
		/*
		this.getEmpresa(id)
		.ifPresentOrElse((empresa) -> {
			
			//removendo a empresa
			empresas.remove(empresa);
			
		}
		,()->{
			throw new NoSuchElementException("A empresa não foi encontrada!");
		});
		
		*/
	}
	
	public Optional<Empresa> getEmpresa(Integer id) {
		
		return Banco.empresas.stream()
				.filter((Empresa empresa) -> empresa.getId() == id)
				.findFirst();
		
	}
	
	

}
