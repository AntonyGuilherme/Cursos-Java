package br.com.alura.leilao.dao;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;

import br.com.alura.leilao.model.Usuario;
import br.com.alura.leilao.util.JPAUtil;

class UsuarioDaoTest {

	private UsuarioDao dao;
	private EntityManager em;
	
	@Test
	void testeBuscaDeUsuarioPeloUserName() {
	
		this.em = JPAUtil.getEntityManager();
		this.dao = new UsuarioDao(em);
	
		Usuario usuario = new Usuario("fulano","fulano@email.com","12345678");
		this.em.getTransaction().begin();
		this.em.persist(usuario);
		this.em.getTransaction().commit();
		
		Usuario usuarioDoBancoDeDados = this.dao.buscarPorUsername(usuario.getNome());
		
		assertNotNull(usuarioDoBancoDeDados);
		
	}

}
