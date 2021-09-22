package br.com.alura.spring_data.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.alura.spring_data.orm.Funcionario;
import br.com.alura.spring_data.orm.FuncionarioDTO;
import br.com.alura.spring_data.orm.FuncionarioProjecao;

public interface FuncionarioRepository extends 
PagingAndSortingRepository<Funcionario, Integer> , JpaSpecificationExecutor<Funcionario>  {

	List<Funcionario> findByNome(String nome);
	
	/**
	 * 
	 * @param nome - dev utilizar o pattern %%. "%Anton%"
	 * @return uma lista de funcionários
	 */
	Page<Funcionario> findByNomeLike(String nome,Pageable pageable);
	
	List<Funcionario> findByNomeEndingWith(String nome);
	List<Funcionario> findByNomeStartingWith(String nome);
	List<Funcionario> findByNomeIsNull();
	List<Funcionario> findByNomeIsNotNull();
	List<Funcionario> findByNomeOrderByNomeAsc(String nome);
	
	
	@Query("SELECT F FROM Funcionario F WHERE F.nome = :nome and "
			+ "F.salario >= :salario AND F.dataContratacao = :dataContratacao")
	List<Funcionario> findNomeSalarioMaiorDataContracao(
			String nome, BigDecimal salario, 
			LocalDate dataContratacao);
	
	List<Funcionario> findByCargoDescricao(String descricao);
	@Query("SELECT f FROM Funcionario f JOIN f.cargo c WHERE c.descricao = :descricao")
	List<Funcionario> findByCargoPelaDescricao(String descricao);
	
	//UnidadeTrabalho é composto de duas palavras. Para separar claramente
	//o nome da entidade do atributo devemos usar o caracter _
	List<Funcionario> findByUnidadeTrabalhos_Descricao(String descricao);
	
	@Query("SELECT f FROM Funcionario f JOIN f.unidadeTrabalhos u WHERE u.descricao = :descricao")
	List<Funcionario> findByUnidadeTrabalhosPelaDescricao(String descricao);
	
	// Query nativa
	@Query(
			value ="SELECT * FROM funcionarios f WHERE f.data_contratacao >= :data", 
			nativeQuery = true
			)
	List<Funcionario> findDataContratacaoMaior(LocalDate data);
	
	
	@Query(value="SELECT f.id , f.nome , f.salario  FROM Funcionarios f" , nativeQuery = true)
	List<FuncionarioProjecao> findFuncionarioSalario();
	
	@Query("SELECT new br.com.alura.spring_data.orm.FuncionarioDTO(f.id , f.nome , f.salario)"
			+ "  FROM Funcionario f" )
	List<FuncionarioDTO> findFuncionarioSalarioDTO();
}
