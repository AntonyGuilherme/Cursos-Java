package br.com.alura.loja.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

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

		/// :nome ou ?1
		String jpql = "SELECT P FROM Produto P WHERE P.categoria.nome = ?1";
		return em.createQuery(jpql, Produto.class)
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
	

}
