package br.com.alura.loja.orcamento;

import java.util.Map;

import br.com.alura.loja.DomainException;
import br.com.alura.loja.http.HttpAdapter;

public class RegistroDeOrcamento {
    
    private HttpAdapter http;


    public RegistroDeOrcamento(HttpAdapter http) {
        this.http = http;
    }



    public void registrar(Orcamento orcamento){

        if(!orcamento.isFinalizado()){
            throw new DomainException("orcamento nao finalizado");
        }
    
        String url = "http://api.externa/orcamento";

        Map<String, Object> dados = Map.of(
            "valor",orcamento.getValor(),
            "quantidadeItens", orcamento.getQuantidade()
        );

        //chama hhtp para API externa
        http.post(url, dados);
    
    }

}
