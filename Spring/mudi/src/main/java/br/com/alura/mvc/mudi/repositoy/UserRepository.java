package br.com.alura.mvc.mudi.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.mvc.mudi.model.User;

public interface UserRepository extends JpaRepository<User, String> {

	
}
