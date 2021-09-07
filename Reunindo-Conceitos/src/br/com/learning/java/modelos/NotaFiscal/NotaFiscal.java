package br.com.learning.java.modelos.NotaFiscal;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;


public class NotaFiscal {

    private final int codigo;
    private final Collection<Produto> produtos = new HashSet<>();

    public NotaFiscal(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void inserirProduto(Produto produto){

        if(produto == null || this.produtos.contains(produto)) {
            throw new IllegalArgumentException("O produto é inválido ou já foi adicionado!");
        }

        this.produtos.add(produto);
    }

    public Collection<Produto> getProdutos() {
        return Collections.unmodifiableCollection(this.produtos);
    }

    public double getValor() {
        return this.produtos
                .stream()
                .mapToDouble((produto) -> produto.getValor().doubleValue())
                .sum();
    }
}
