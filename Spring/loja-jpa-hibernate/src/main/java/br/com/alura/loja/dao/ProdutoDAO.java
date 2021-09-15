package br.com.alura.loja.dao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;

public class ProdutoDAO {

	private EntityManager em;

	public ProdutoDAO(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(Produto produto) {
		this.em.persist(produto);
	}

	public void atualizar(Categoria categoria) {
		this.em.merge(categoria);
	}

	public void remover(Categoria categoria) {
		categoria = this.em.merge(categoria);
		this.remover(categoria);
	}

	public Produto burcarPorId(Long id) {
		return this.em.find(Produto.class, id);
	}

	public List<Produto> buscarTodos() {

		String jpql = "SELECT P FROM Produto P";
		return this.em
				.createQuery(jpql, Produto.class)
				.getResultList();

	}

	public List<Produto> buscarPorNome(String nome) {

		/// :nome ou ?1
		String jpql = "SELECT P FROM Produto P WHERE P.nome = ?1";
		return em.createQuery(jpql, Produto.class)
				.setParameter(1, nome)
				.getResultList();

	}

	public List<Produto> buscarPorNomeDaCategoria(String nome) {

		return em.createNamedQuery("produtosPorCategoria", Produto.class)
				.setParameter(1, nome)
				.getResultList();

	}
	
	
	public BigDecimal buscarPrecoDoProdutoComNome(String nome) {

		/// :nome ou ?1
		String jpql = "SELECT P.preco FROM Produto P WHERE P.nome = ?1";
		return em.createQuery(jpql, BigDecimal.class)
				.setParameter(1, nome)
				.getSingleResult();

	}
	
	
	
	public List<Produto> buscarPorParametros(
			String nome,
			BigDecimal preco, 
			LocalDate dataCadastro){

		String jpql = "SELECT p FROM Produto p WHERE 1=1 ";
		
		if(nome != null && nome.isBlank()) {
			jpql  += " AND nome = :nome "; 
		}
		
		if(preco != null) {
			jpql += " AND preco = :preco ";
		}
		
		if(dataCadastro != null) {
			jpql += " AND dataCadastro = :data";
		}
		
		TypedQuery<Produto> query = this.em.createQuery(jpql,Produto.class);
		
		if(nome != null && nome.isBlank()) {
			query.setParameter("nome", nome); 
		}
		
		if(preco != null) {
			query.setParameter("preco", preco);
		}
		
		if(dataCadastro != null) {
			query.setParameter("data", dataCadastro);
		}
		
		return query.getResultList();
		
	
		
		
	}
	
	public List<Produto> buscarPorParametrosComCriteria(
			String nome,
			BigDecimal preco, 
			LocalDate dataCadastro){

		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		
		CriteriaQuery<Produto> query = criteriaBuilder.createQuery(Produto.class);
		Root<Produto> from = query.from(Produto.class);
		
		Predicate filtros = criteriaBuilder.and();
		
		if(nome != null && nome.isBlank()) {
			filtros = criteriaBuilder.and(filtros, criteriaBuilder.equal(from.get("nome"), nome)); 
		}
		
		if(preco != null) {
			filtros = criteriaBuilder.and(filtros, criteriaBuilder.equal(from.get("preco"), preco)); 
		}
		
		if(dataCadastro != null) {
			filtros = criteriaBuilder.and(filtros, criteriaBuilder.equal(from.get("dataCadastro"), dataCadastro)); 
		}
		
		query.where(filtros);
		
		return em.createQuery(query).getResultList();
		
	}
	

}
