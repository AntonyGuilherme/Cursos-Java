package br.com.learning.java.modelos.NotaFiscal;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Produto {

    private final int codigo;
    private final String nome;
    private final BigDecimal valor;


    public Produto(int codigo,String nome, BigDecimal valor) {
        this.codigo = codigo;
        this.nome = nome;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public int getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return String.format(
                "Código %d , Nome %s , Valor %s",
                this.getCodigo(),this.getNome(),
                this.getValor().setScale(2, RoundingMode.HALF_UP)
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return codigo == produto.codigo && nome.equals(produto.nome) && valor.equals(produto.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, nome, valor);
    }
}
