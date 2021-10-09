package br.com.alura.loja.orcamento;

import java.math.BigDecimal;

public class OrcavelProxy {
    
    private BigDecimal valor;
    private Orcavel orcavel;

    
    public OrcavelProxy(Orcavel orcavel) {
        this.orcavel = orcavel;
    }

    public BigDecimal getValor() {

        if(valor == null){
            this.valor = orcavel.getValor();
        }

        return valor;
    }

    



}
