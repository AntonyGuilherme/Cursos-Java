package br.com.alura.tdd.modelo;

public enum PercentualReajuste {

    PERCENTUAL_REAJUSTE_A_DESEJAR("0.03"),
    PERCENTUAL_REAJUSTE_BOM("0.15"),
    PERCENTUAL_REAJUSTE_OTIMO("0.20");

    private final String percentual;

    PercentualReajuste(String taxa){
        this.percentual = taxa;
    }

    public String getPercentual() {
        return this.percentual;
    }

}
