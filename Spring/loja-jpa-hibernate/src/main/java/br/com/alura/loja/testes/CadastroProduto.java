package br.com.alura.loja.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.CategoriaDAO;
import br.com.alura.loja.dao.ProdutoDAO;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;

public class CadastroProduto {
	
	public static void main(String[] args) {
		
		//cadastroERemocao();
		
		Long id = 7l;
		
		EntityManager entityManager = JPAUtil.getEntityManager();
		ProdutoDAO produtoDAO = new ProdutoDAO(entityManager);
		
		Produto produto = produtoDAO.burcarPorId(id);
		System.out.println(produto);
		
		
		produtoDAO.buscarTodos()
		.stream()
		.map(Produto::getNome)
		.forEach(System.out::println);
		
		produtoDAO.buscarPorNome("G5")
		.stream()
		.map(Produto::getNome)
		.forEach(System.out::println);
		
		
		produtoDAO.buscarPorNomeDaCategoria("ELETRONICOS")
		.stream()
		.map(Produto::getNome)
		.forEach(System.out::println);
		
		System.out.println(produtoDAO.buscarPrecoDoProdutoComNome("G42"));
		
	}

	private static void cadastroERemocao() {
		EntityManager entityManager = JPAUtil.getEntityManager();

		entityManager.getTransaction().begin();
		
		ProdutoDAO produtoDAO = new ProdutoDAO(entityManager);		
		CategoriaDAO categoriaDAO = new CategoriaDAO(entityManager);
		
		
		/*
		 * 	Transient - Não está no banco, ou seja, ações realizadas nesse estado não são gravadas
		 *	Managed - sincronizada com o banco, ou seja ações realizadas são refletidas no banco de dados
		 * 	Detached - já persistida, ou seja, os itens não mais são refletidos 
		 */
		
		// Transient
		Categoria celulares = new Categoria("CELULARES");
		Produto celular = new Produto("G42","Descricao",new BigDecimal("45"),celulares);
		

		// Managed
		categoriaDAO.cadastrar(celulares);
		produtoDAO.cadastrar(celular);


		//entityManager.getTransaction().commit();
		
		//sincronizar com o banco
		entityManager.flush();
		
		//parar de sincronizar
		entityManager.clear();
		
		// Detached

		celulares = entityManager.merge(celulares);
		
		celulares.setNome("ELETRONICOS");
		
		entityManager.flush();
		
		entityManager.getTransaction().commit();
		entityManager.clear();
		entityManager.close();
		
		
		/*Produto produto = entityManager.find(Produto.class, 1l);
		System.out.println(produto.getNome());
		
		entityManager.getTransaction().begin();
		entityManager.remove(produto);
		entityManager.getTransaction().commit();
		entityManager.close();*/
	}

}
