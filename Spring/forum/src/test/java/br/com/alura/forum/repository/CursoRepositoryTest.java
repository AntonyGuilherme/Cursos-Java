package br.com.alura.forum.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import br.com.alura.forum.modelo.Curso;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
@ActiveProfiles("test")
public class CursoRepositoryTest {

	@Autowired
	private CursoRepository cursoRepository;
	
	@Autowired
	private TestEntityManager em;
	
	@Test
	public void deveriaCarregarUmCursoAoBuscarPeloSeuNome() {
		
		Curso curso = new Curso("Spring-API","Spring");
		em.persist(curso);

		
		String nomeCurso = "Spring-API";
		Curso cursoPesquisa = this.cursoRepository.findByNome(nomeCurso);
		
		assertNotNull(cursoPesquisa);
		assertEquals(nomeCurso, cursoPesquisa.getNome());
		
	}
	
	@Test
	public void naoDeveriaCarregarUmCursoAoBuscarPorUmNomeInexistente() {
		
		String nomeCurso = "JPA";
		Curso curso = this.cursoRepository.findByNome(nomeCurso);
		
		assertNull(curso);
		
	}

}
