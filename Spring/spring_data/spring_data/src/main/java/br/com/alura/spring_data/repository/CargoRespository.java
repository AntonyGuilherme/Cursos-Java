package br.com.alura.spring_data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.spring_data.orm.Cargo;

@Repository
public interface CargoRespository extends CrudRepository<Cargo,Integer> {
	
	

}
