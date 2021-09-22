package br.com.alura.spring_data.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.com.alura.spring_data.orm.Funcionario;
import br.com.alura.spring_data.repository.FuncionarioRepository;
import br.com.alura.spring_data.specification.SpecificationFuncionario;


@Service
public class RelatorioFuncionarioDinamico extends Acao {

	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	
	private final FuncionarioRepository funcionarioRepository;
	
	public RelatorioFuncionarioDinamico(FuncionarioRepository funcionarioRepository) {
		super(5,"RELATORIO DINAMICO");
		this.funcionarioRepository = funcionarioRepository;
		
	}

	@Override
	public void iniciar(Scanner scanner) {
		
		System.out.println("DIGITE O NOME");
		String nome = scanner.next();
		
		if(nome.equalsIgnoreCase("NULL")) {
			nome = null;
		}
		
		System.out.println("DIGITE O CPF");
		String cpf = scanner.next();
		
		if(cpf.equalsIgnoreCase("NULL")) {
			cpf = null;
		}
		
		System.out.println("DIGITE O SALARIO");
		BigDecimal salario = scanner.nextBigDecimal();
		
		if(salario.equals(new BigDecimal("0"))) {
			salario = null;
		}
		
		System.out.println("DIGITE A Data de Contratacao");
		String data = scanner.next();
		LocalDate dataContratacao = null;
		
		if(data.equalsIgnoreCase("NULL")) {
			data = null;
		}else {
			dataContratacao = LocalDate.parse(data,formatter);
		}
		
		System.out.println(nome);
		System.out.println(cpf);
		System.out.println(salario);
		System.out.println(dataContratacao);
		
		List<Funcionario> funcionarios = this.funcionarioRepository
				.findAll(
						Specification
						.where(SpecificationFuncionario.nome(nome))
						.and(SpecificationFuncionario.cpf(cpf))
						.and(SpecificationFuncionario.salario(salario))
						.and(SpecificationFuncionario.dataContratacao(dataContratacao))
						);
		
		funcionarios.forEach(System.out::println);
		
	}
	
}
