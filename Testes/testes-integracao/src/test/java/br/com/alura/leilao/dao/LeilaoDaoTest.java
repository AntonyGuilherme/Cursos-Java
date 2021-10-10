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
import br.com.alura.leilao.util.builder.LeilaoBuilder;
import br.com.alura.leilao.util.builder.UsuarioBuilder;

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
		
		Usuario usuario = new UsuarioBuilder()
				.comNome("fulano")
				.comEmail("fulano@email.com")
				.comSenha("12345678")
				.criar();
		
		this.em.persist(usuario);
		
		Leilao leilao = new LeilaoBuilder()
				.comData(LocalDate.now())
				.comNome("Mochila")
				.comValor("100")
				.comUsuario(usuario)
				.criar();
		
		leilao = this.dao.salvar(leilao);
		Leilao leilaoBuscadoDoBanco = dao.buscarPorId(leilao.getId());
		assertNotNull(leilaoBuscadoDoBanco);
		
	}
	
	@Test
	void deveriaAtualizarUmLeilao() {
		
		Usuario usuario = new UsuarioBuilder()
				.comNome("fulano")
				.comEmail("fulano@email.com")
				.comSenha("12345678")
				.criar();
		
		this.em.persist(usuario);
		
		Leilao leilao = new LeilaoBuilder()
				.comData(LocalDate.now())
				.comNome("Mochila")
				.comValor("100")
				.comUsuario(usuario)
				.criar();
		
		
		leilao = this.dao.salvar(leilao);
		
		leilao.setNome("Celular");
		leilao.setValorInicial(BigDecimal.TEN);
		
		dao.salvar(leilao);
		
		Leilao leilaoBuscadoDoBanco = dao.buscarPorId(leilao.getId());
		assertEquals(leilao.getNome(),leilaoBuscadoDoBanco.getNome());
		assertEquals(leilao.getValorInicial(),leilaoBuscadoDoBanco.getValorInicial());
		
	}
	

}
