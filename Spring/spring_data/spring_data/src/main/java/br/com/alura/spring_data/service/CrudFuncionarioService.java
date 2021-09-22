package br.com.alura.spring_data.service;


import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.alura.spring_data.orm.Cargo;
import br.com.alura.spring_data.orm.Funcionario;
import br.com.alura.spring_data.orm.UnidadeTrabalho;
import br.com.alura.spring_data.repository.CargoRespository;
import br.com.alura.spring_data.repository.FuncionarioRepository;
import br.com.alura.spring_data.repository.UnidadeTrabalhoRepository;

@Service
public class CrudFuncionarioService extends Acao {

	
	private final FuncionarioRepository funcionarioRepository;
	private final CargoRespository cargoRespository;
	private final UnidadeTrabalhoRepository unidadeRepository;
	private final List<String> acoes = List.of(
			"Salvar 1","Atualizar 2",
			"Visualizar 3","Deletar 4",
			"Unidades 5");
	private Boolean system = true;
	
	public CrudFuncionarioService(
			FuncionarioRepository funcionarioRepository,
			CargoRespository cargoRespository,
			UnidadeTrabalhoRepository unidadeRepository
			){
		super(2,"GERENCIAR FUNCIONARIO");
		this.funcionarioRepository = funcionarioRepository;
		this.cargoRespository = cargoRespository;
		this.unidadeRepository = unidadeRepository;
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
				this.visualizar(scanner);
				break;
			
			case 4:
				this.deletar(scanner);
				break;		
			
			case 5:
				this.gerenciarUnidadesFuncionario(scanner);
				break;
			default:
				this.system = false;
				break;
			}
			
		}

	}
	
	
	
	private void gerenciarUnidadesFuncionario(Scanner scanner) {
		
		
		System.out.println("INFORME O ID");
		
		Integer idFuncionario = scanner.nextInt();
		
		Funcionario funcionario = this.funcionarioRepository.findById(idFuncionario).get();
		
		System.out.println(funcionario);
		
		System.out.println("Informe o Id da Unidade");
		Integer idUnidade = scanner.nextInt();
		UnidadeTrabalho unidade = this.unidadeRepository.findById(idUnidade).get();
		
		Boolean unidadeCadastrada = funcionario.removerUnidade(unidade);
		
		
		if(!unidadeCadastrada) {
			funcionario.adicionarUnidade(unidade);
		}
		
		
		this.funcionarioRepository.save(funcionario);
		
		
		
		
	}


	public void salvar(Scanner scanner) {
		
		System.out.println("Nome");
		String nome = scanner.next();

		System.out.println("CPF");
		String cpf = scanner.next();

		System.out.println("Salario");
		BigDecimal salario = scanner.nextBigDecimal();
		
		System.out.print("Digite o id do Cargo");
		Integer idCargo = scanner.nextInt();
		Cargo cargo = this.cargoRespository.findById(idCargo).get();
		
		Funcionario funcionario = new Funcionario(nome,cpf,salario);
		funcionario.setCargo(cargo);
		
		this.funcionarioRepository.save(funcionario);
		
		System.out.println("SALVO COM SUCESSO");
		
	}
	
	
	
	
	
	
	
	public void visualizar(Scanner scanner) {
		
		System.out.println("Qual pagina voce deseja visualizar?");
		Integer page = scanner.nextInt();
		
		//Pageable pageable = PageRequest.of(page, 5,Sort.by(Sort.Direction.DESC,"nome"));
		Pageable pageable = PageRequest.of(page, 5,Sort.by(Sort.Direction.DESC,"salario"));
		Page<Funcionario> funcionarios =  this.funcionarioRepository.findAll(pageable);
		
		System.out.println(funcionarios);
		System.out.println("Pagina atual "+ funcionarios.getNumber());
		System.out.println("Total elemento "+ funcionarios.getTotalElements());
		
		funcionarios.forEach(System.out::println);
		
		
	}
	
	
	
	
	
	
	
	
	public void deletar(Scanner scanner) {
		
		System.out.println("INFORME UM ID :");
		Integer id = scanner.nextInt();
		
		this.funcionarioRepository.deleteById(id);
		
		System.out.println("ATUALIZADO COM SUCESSO");
		
	}

	public void atualizar(Scanner scanner) {
		
		System.out.println("INFORME O ID");
		Integer id = scanner.nextInt();
		
		Funcionario funcionario = this.funcionarioRepository.findById(id).get();
		
		System.out.println("Nome");
		funcionario.setNome(scanner.next());

		System.out.println("CPF");
		funcionario.setCpf(scanner.next());

		System.out.println("Salario");
		funcionario.setSalario(scanner.nextBigDecimal());
		
		
		this.funcionarioRepository.save(funcionario);
		
		System.out.println("SALVO COM SUCESSO");
		
	}
	
}
