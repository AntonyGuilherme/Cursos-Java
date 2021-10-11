package br.com.alura.leilao.dao;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.leilao.model.Usuario;
import br.com.alura.leilao.util.JPAUtil;
import br.com.alura.leilao.util.builder.UsuarioBuilder;

class UsuarioDaoTest {

	private UsuarioDao dao;
	private EntityManager em;
	
	
	@BeforeEach
	public void beforeEach() {
		this.em = JPAUtil.getEntityManager();
		this.dao = new UsuarioDao(em);
		this.em.getTransaction().begin();
	}
	
	@AfterEach
	public void afterEach() {
		this.em.getTransaction().rollback();
	}
	
	
	@Test
	void deveriaEncontrarUmUsuarioCadastrado() {
	
		Usuario usuario = new UsuarioBuilder()
				.comNome("fulano")
				.comEmail("fulano@email.com")
				.comSenha("12345678")
				.criar();
		
		this.em.persist(usuario);
		
		Usuario usuarioDoBancoDeDados = this.dao.buscarPorUsername(usuario.getNome());
		
		assertNotNull(usuarioDoBancoDeDados);
		
	}
	
	@Test
	void naodeveriaEncontrarUmUsuarioNaoCadastrado() {
	
		Usuario usuario = new UsuarioBuilder()
				.comNome("fulano")
				.comEmail("fulano@email.com")
				.comSenha("12345678")
				.criar();
		
		this.em.persist(usuario);
		assertThrows(NoResultException.class,() -> this.dao.buscarPorUsername("beltrano"));
		
	}
	
	
	@Test
	void deveriaRemoverUmUsuario() {
		
		Usuario usuario = new UsuarioBuilder()
				.comNome("fulano")
				.comEmail("fulano@email.com")
				.comSenha("12345678")
				.criar();
		
		this.em.persist(usuario);
		
		dao.deletar(usuario);
		assertThrows(NoResultException.class,() -> this.dao.buscarPorUsername("fulano"));
	}
	
	

}
