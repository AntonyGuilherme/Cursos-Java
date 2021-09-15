package br.com.alura.loja.testes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.CategoriaDAO;
import br.com.alura.loja.dao.ClienteDAO;
import br.com.alura.loja.dao.PedidoDAO;
import br.com.alura.loja.dao.ProdutoDAO;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Cliente;
import br.com.alura.loja.modelo.ItemPedido;
import br.com.alura.loja.modelo.Pedido;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;
import br.com.alura.loja.vo.RelatorioDeVendasVo;

public class CadastroDePedido {

	public static void main(String[] args) {
		
		cadastrarPedido();
		cadastrarClienteEProduto();
		
		EntityManager entityManager = JPAUtil.getEntityManager();
		
		
		//BigDecimal valorTotalVendido = pedidoDAO.valorTotalVendido();
		//System.out.println(valorTotalVendido);
		
		//List<RelatorioDeVendasVo> relatorio = pedidoDAO.relatorioDeVendas();
		
		//relatorio.forEach(System.out::println);
		
		
		//produtoDAO.buscarPorNomeDaCategoria("CELULARES")
		//.forEach(System.out::println);;
		
		
		PedidoDAO pedidoDAO = new PedidoDAO(entityManager);
		Pedido produtoClienteLazy = pedidoDAO.buscarPedidoComCliente(1l);
		
		new ProdutoDAO(entityManager)
		.buscarPorParametrosComCriteria("s20", new BigDecimal("100"), null)
		.forEach(System.out::println);
		
		entityManager.close();
		
		System.out.println(produtoClienteLazy.getCliente().getNome());
		
		
		
		
		

	}
	
	
	private static void cadastrarClienteEProduto() {
		
		EntityManager entityManager = JPAUtil.getEntityManager();
		ProdutoDAO produtoDAO = new ProdutoDAO(entityManager);

		ClienteDAO clienteDAO = new ClienteDAO(entityManager);
		PedidoDAO pedidoDAO = new PedidoDAO(entityManager);
		
		Produto produto = produtoDAO.burcarPorId(1l);
		Cliente cliente = new Cliente("Rodrigo","123456789"); 
		
		Pedido pedido = new Pedido(cliente);
		pedido.adicionarItem(new ItemPedido(10,pedido,produto));
		
		
		entityManager.getTransaction().begin();
		
		clienteDAO.cadastrar(cliente);
		pedidoDAO.cadastrar(pedido);
		
		entityManager.getTransaction().commit();
		
		
		BigDecimal valorTotalVendido = pedidoDAO.valorTotalVendido();
		System.out.println(valorTotalVendido);
				
		List<RelatorioDeVendasVo> relatorio = pedidoDAO.relatorioDeVendas();
				
		relatorio.forEach(System.out::println);
				
				
		produtoDAO
			.buscarPorNomeDaCategoria("CELULARES")
			.forEach(System.out::println);;
				
		
		entityManager.close();
		
		
	}
	
	
	private static void cadastrarPedido() {
		
		Categoria categoria = new Categoria("CELULARES");
		Produto produto = new Produto("Galaxy","S20",new BigDecimal("100"),categoria);
	
		EntityManager entityManager = JPAUtil.getEntityManager();
		CategoriaDAO categoriaDAO = new CategoriaDAO(entityManager);
		ProdutoDAO produtoDAO = new ProdutoDAO(entityManager);
		
		produtoDAO.cadastrar(produto);
		
		entityManager.getTransaction().begin();
		
		categoriaDAO.cadastrar(categoria);
		produtoDAO.cadastrar(produto);
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
		
	}

}
