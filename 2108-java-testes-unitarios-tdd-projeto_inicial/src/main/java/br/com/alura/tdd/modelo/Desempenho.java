package br.com.alura.tdd.modelo;

import java.math.BigDecimal;

public enum Desempenho {

    A_DESEJAR(PercentualReajuste.PERCENTUAL_REAJUSTE_A_DESEJAR),
    BOM(PercentualReajuste.PERCENTUAL_REAJUSTE_BOM),
    OTIMO(PercentualReajuste.PERCENTUAL_REAJUSTE_OTIMO);

    private final PercentualReajuste percentualReajusteSalarial;

    Desempenho(PercentualReajuste taxaReajusteSalarial){
        this.percentualReajusteSalarial = taxaReajusteSalarial;
    }

    public BigDecimal getPercentualReajusteSalarial(){
        return new BigDecimal(this.percentualReajusteSalarial.getPercentual());
    }

}
