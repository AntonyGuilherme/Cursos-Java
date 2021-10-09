package br.com.alura.loja;

import java.math.BigDecimal;

import br.com.alura.loja.orcamento.ItemOrcamento;
import br.com.alura.loja.orcamento.Orcamento;

public class TestesComposicao {
    
    public static void main(String[] args) {
        
        Orcamento antigo = new Orcamento();
        antigo.adicionarItens(new ItemOrcamento(BigDecimal.TEN));


        Orcamento novoOrcamento = new Orcamento();
        antigo.adicionarItens(new ItemOrcamento(BigDecimal.TEN));
        novoOrcamento.adicionarItens(antigo);

        System.out.println(novoOrcamento.getValor());

    }

}
