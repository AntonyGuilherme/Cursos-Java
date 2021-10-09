package br.com.alura.loja.pedido.acao;

import br.com.alura.loja.pedido.Pedido;

public class LogDePedido implements AcaoAposGerarPedido {

    @Override
    public void executar(Pedido pedido) {
        
        System.out.format("Pedido Gerado %s",pedido);
        
    }
    


}
