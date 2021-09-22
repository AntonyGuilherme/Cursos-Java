package br.com.alura.spring_data.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.autoconfigure.cassandra.CassandraProperties.Request;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.alura.spring_data.orm.Funcionario;
import br.com.alura.spring_data.orm.FuncionarioProjecao;
import br.com.alura.spring_data.repository.FuncionarioRepository;

@Service
public class RelatoriosService extends Acao {

	private final FuncionarioRepository funcionarioRespository;
	private Boolean system = true;
	private final List<String> acoes = List.of(
			"Busca Funcionario Por Nome: 1",
			"Busca Por Nome,Salario e DataContratacao 2",
			"Busca Por DataContratacao 3",
			"Busca por salario 4"
			);
	
	public RelatoriosService(FuncionarioRepository funcionarioRepository) {
		
		super(4,"RELATORIOS");
		
		this.funcionarioRespository = funcionarioRepository;
		
	}
	
	@Override
	public void iniciar(Scanner scanner) {
		
		while(system) {
			
			acoes.forEach(System.out::println);
			
			int action = scanner.nextInt();
			
			
			
			switch (action) {
			
			case 1:
				this.buscaFuncionarioNome(scanner);
				break;
			
			case 2:
				this.buscarFuncionarioNomeSalarioMaiorData(scanner);
				break;
			
			case 3:
				this.buscaFuncionarioDataContratacao(scanner);
				break;
			
			case 4:
				this.buscaFuncionarioSalario();
				break;		
				
			default:
				this.system = false;
				break;
			}
			
		}
		
	}

	private void buscaFuncionarioSalario() {
		
		List<FuncionarioProjecao> list =  this.funcionarioRespository.findFuncionarioSalario();
		
		list.forEach((funcionarioProjecao) -> System.out.format(
				"ID %d Nome %s Salario %s \n", 
				funcionarioProjecao.getId(),
				funcionarioProjecao.getNome(),
				funcionarioProjecao.getSalario()
				));
		
		System.out.println("SAIDA DTO");
		
		this.funcionarioRespository
		.findFuncionarioSalarioDTO()
		.forEach(System.out::println);
		
	}

	private void buscaFuncionarioNome(Scanner scanner) {
		
		System.out.println("INFORME A PAGINA DESEJADA");
		Integer pagina = scanner.nextInt();
		
		Pageable pageable = PageRequest.of(pagina, 10,Sort.unsorted());
		
		System.out.println("INFORME O NOME DO FUNCIONARIO");
		String nome = scanner.next();
		
		
		
		Page<Funcionario> funcionarios = this.funcionarioRespository.findByNomeLike(nome,pageable);
		
		System.out.format(
				"Info : %s \n Pagina Atual : %d \n Total : %d \n", 
				funcionarios, funcionarios.getNumber() , funcionarios.getTotalElements());
		
		funcionarios.forEach(System.out::println);
		
		
		
	}
	
	private void buscarFuncionarioNomeSalarioMaiorData(Scanner scanner) {
		
		System.out.println("INFORME O NOME DO FUNCIONARIO");
		String nome = scanner.next();
		
		System.out.println("INFORME A DATA:");
		String data = scanner.next();
		
		System.out.println("INFORME O SALARIO:");
		BigDecimal salario = scanner.nextBigDecimal();
		
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		LocalDate localDate = LocalDate.parse(data,formatter);
		
		
		this.funcionarioRespository
		.findNomeSalarioMaiorDataContracao(nome, salario, localDate)
		.forEach(System.out::println);
	
	}
	
	
	private void buscaFuncionarioDataContratacao(Scanner scanner) {
		
		System.out.println("DATA DE CONTRATACO");
		System.out.println("INFORME A DATA:");
		String data = scanner.next();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate localDate = LocalDate.parse(data,formatter);
		this.funcionarioRespository
		.findDataContratacaoMaior(localDate)
		.forEach(System.out::println);
		
	}
	
	
	
}
