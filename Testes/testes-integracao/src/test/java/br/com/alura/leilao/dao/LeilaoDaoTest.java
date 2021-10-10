package br.com.alura.leilao.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import br.com.alura.leilao.util.JPAUtil;

class LeilaoDaoTest {

	private LeilaoDao dao;
	private EntityManager em;
	
	
	@BeforeEach
	public void beforeEach() {
		this.em = JPAUtil.getEntityManager();
		this.dao = new LeilaoDao(em);
		this.em.getTransaction().begin();
	}
	
	@AfterEach
	public void afterEach() {
		this.em.getTransaction().rollback();
	}
	
	
	@Test
	void deveriaCadastrarUmLeilao() {
		
		Usuario usuario = criarUsuario();
		Leilao leilao = new Leilao("Mochila", new BigDecimal("70"), LocalDate.now(),usuario);
		
		leilao = this.dao.salvar(leilao);
		Leilao leilaoBuscadoDoBanco = dao.buscarPorId(leilao.getId());
		assertNotNull(leilaoBuscadoDoBanco);
		
	}
	
	@Test
	void deveriaAtualizarUmLeilao() {
		
		Usuario usuario = criarUsuario();
		Leilao leilao = new Leilao("Mochila", new BigDecimal("70"), LocalDate.now(),usuario);
		
		leilao = this.dao.salvar(leilao);
		
		leilao.setNome("Celular");
		leilao.setValorInicial(BigDecimal.TEN);
		
		dao.salvar(leilao);
		
		Leilao leilaoBuscadoDoBanco = dao.buscarPorId(leilao.getId());
		assertEquals(leilao.getNome(),leilaoBuscadoDoBanco.getNome());
		assertEquals(leilao.getValorInicial(),leilaoBuscadoDoBanco.getValorInicial());
		
	}
	
	
	private Usuario criarUsuario() {
		Usuario usuario = new Usuario("fulano","fulano@email.com","12345678");
		this.em.persist(usuario);
		return usuario;
	}

}
