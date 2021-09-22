package br.com.alura.spring_data.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.alura.spring_data.orm.UnidadeTrabalho;

public interface UnidadeTrabalhoRepository extends CrudRepository<UnidadeTrabalho, Integer> {

}
