package br.com.alura.spring_data;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.alura.spring_data.repository.UnidadeTrabalhoRepository;
import br.com.alura.spring_data.service.Acao;
import br.com.alura.spring_data.service.CrudCargoService;
import br.com.alura.spring_data.service.CrudFuncionarioService;
import br.com.alura.spring_data.service.CrudUnidadeTrabalhoService;
import br.com.alura.spring_data.service.RelatorioFuncionarioDinamico;
import br.com.alura.spring_data.service.RelatoriosService;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	private Boolean system = true;
	private final List<Acao> services;
	
	public SpringDataApplication(
			CrudCargoService cargoService,
			CrudFuncionarioService funcionarioService,
			CrudUnidadeTrabalhoService unidadeService,
			RelatoriosService relatorios,
			RelatorioFuncionarioDinamico relatoriosDinamicos
			) {
		this.services = List.of(
				cargoService,funcionarioService,
				unidadeService,relatorios, relatoriosDinamicos);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}
	
	@Override
	public void run(String ...args) throws Exception{
		
		Scanner scanner = new Scanner(System.in);
		
		while(system) {
			
			//Mostrando as descrições
			this.services
			.forEach(System.out::println);
			
			Integer codigo = scanner.nextInt();
			
			this.services
			.stream()
			.filter((acao) -> acao.getCodigo() == codigo)
			.findFirst()
			.ifPresentOrElse((acao)-> {
				
				acao.iniciar(scanner);
				
			}, () -> {
				this.system = false;
			});
			
			
		}
		
	}

}
