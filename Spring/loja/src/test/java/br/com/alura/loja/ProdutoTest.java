package br.com.alura.loja;

import static org.junit.Assert.*;

import org.junit.Test;

public class ProdutoTest {

	@Test
	public void test() {
		
		String nomeProdutoTeste = "Teste";
		
		Produto produto = new Produto(nomeProdutoTeste);
		
		assertEquals(nomeProdutoTeste,produto.getNome());
		
		
	}

}
