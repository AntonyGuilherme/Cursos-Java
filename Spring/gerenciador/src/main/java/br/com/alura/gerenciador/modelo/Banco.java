package br.com.alura.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Banco {
	
	
	private static List<Empresa> empresas = new ArrayList<>();
	private static List<Usuario> usuarios = new ArrayList<>();
	
	static {
		
		empresas.add(new Empresa("Alura",42));
		empresas.add(new Empresa("Caelum",84));
		
		usuarios.add(new Usuario("antony","123"));
		usuarios.add(new Usuario("guilherme","123"));
		
	}
	

	public void adiciona(Empresa empresa) {
		empresas.add(empresa);
	}
	
	public List<Empresa> getEmpresas(){
		return Collections.unmodifiableList(Banco.empresas);
	}

	public boolean deletarEmpresa(Integer id) {
		return empresas.removeIf((empresa) -> empresa.getId() == id);
	}
	
	public Optional<Empresa> getEmpresa(Integer id) {
		
		return Banco.empresas.stream()
				.filter((Empresa empresa) -> empresa.getId() == id)
				.findFirst();
		
	}

	public boolean existeUsuario(Usuario usuarioParaComparar) {
		
		return Banco.usuarios.stream()
		.anyMatch((usuario) -> usuario.equals(usuarioParaComparar));
		
	}
	
	

}
