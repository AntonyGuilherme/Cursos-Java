package br.com.alura.spring_data.service;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alura.spring_data.orm.Cargo;
import br.com.alura.spring_data.repository.CargoRespository;

@Service
public class CrudCargoService extends Acao {

	private final CargoRespository cargoRespository;
	private Boolean system = true;
	private final List<String> acoes = List.of("Salvar 1","Atualizar 2","Visualizar 3","Deletar 4");
	
	public CrudCargoService(CargoRespository cargoRespository) {
		
		super(1,"GERENCIAR CARGO");
		
		this.cargoRespository = cargoRespository;
		
	}
	
	@Override
	public void iniciar(Scanner scanner) {
		
		while(system) {
			
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
		System.out.println("Descricao do Cargo");
		String descricao = scanner.next();
		
		Cargo cargo = new Cargo(descricao);
		
		this.cargoRespository.save(cargo);
		System.out.println(cargo);
		
	}
	
	
	public void atualizar(Scanner scanner) {
		System.out.println("Digite o ID");
		Integer id = scanner.nextInt();
		this.cargoRespository
		.findById(id)
		.ifPresentOrElse((cargo) -> {
			System.out.println(cargo);
			System.out.println("Digite a nova descrição");
			cargo.setDescricao(scanner.next());
			this.cargoRespository.save(cargo);
			System.out.println("SALVO COM SUCESSO");
		},()-> {
			throw new NoSuchElementException("Cargo não encontrado!");
		});
		
	}
	
	
	public void visualizar() {
		
		cargoRespository.findAll()
		.forEach(System.out::println);
		
	}
	
	
	private void deletar(Scanner scanner) {
	
		System.out.println("ID");
		Integer id = scanner.nextInt();
		this.cargoRespository.deleteById(id);
		
		System.out.println("Deletado com Sucesso");
		
	}

	
	
	
}
