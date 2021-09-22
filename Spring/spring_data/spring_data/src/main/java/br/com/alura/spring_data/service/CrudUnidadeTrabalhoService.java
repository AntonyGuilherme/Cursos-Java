package br.com.alura.spring_data.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alura.spring_data.orm.UnidadeTrabalho;
import br.com.alura.spring_data.repository.UnidadeTrabalhoRepository;

@Service
public class CrudUnidadeTrabalhoService extends Acao {

	private final List<String> acoes = List.of("Salvar 1","Atualizar 2","Visualizar 3","Deletar 4");
	private UnidadeTrabalhoRepository unidadeRepository;
	private Boolean system = true;
	
	public CrudUnidadeTrabalhoService(UnidadeTrabalhoRepository unidadeRepository) {
		super(3,"GERENCIAR UNIDADES");
		
		this.unidadeRepository = unidadeRepository;
		
	}
	
	@Override
	public void iniciar(Scanner scanner) {

		
		while(this.system) {
							
				acoes.forEach(System.out::println);
				
				int action = scanner.nextInt();
				
				
				
				switch (action) {
				
				case 1:
					this.salvar(scanner);
					break;
				
				case 2:
					this.atualizar(scanner);
					break;
				
				case 3:
					this.visualizar();
					break;
				
				case 4:
					this.deletar(scanner);
					break;		
					
				default:
					this.system = false;
					break;
				}
				
			
		}
		
		
			
	}
	
	
	private void salvar(Scanner scanner) {
		
		System.out.println("INFORME A DESCRICAO");
		String descricao = scanner.next();
		System.out.println("INFORME O ENDERECO");
		String endereco = scanner.next();
		
		
		UnidadeTrabalho unidade = new UnidadeTrabalho(descricao,endereco);
		
		this.unidadeRepository.save(unidade);
		
		System.out.println("SALVO COM SUCESSO");
		
		
	}
	
	
	private void visualizar() {
		
		this.unidadeRepository
		.findAll()
		.forEach(System.out::println);
		
	}
	
	
	private void atualizar(Scanner scanner) {
		
		System.out.println("INFORME O ID");
		Integer id = scanner.nextInt();
		
		UnidadeTrabalho unidadeTrabalho =  this.unidadeRepository.findById(id).get();
		
		System.out.println(unidadeTrabalho);
		
		System.out.println("INFORME A DESCRICAO");
		unidadeTrabalho.setDescricao(scanner.next());
		System.out.println("INFORME O ENDERECO");
		unidadeTrabalho.setEndereco(scanner.next());
		
		this.unidadeRepository.save(unidadeTrabalho);
		
		
	}
	
	
	private void deletar(Scanner scanner) {
		
		System.out.println("INFORME O ID");
		Integer id = scanner.nextInt();
		
		this.unidadeRepository.deleteById(id);
		
	}
	
	
	

}
