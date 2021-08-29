package br.com.learning.java;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Factory Method para coleções
        // construção de collections de forma simplificada
        List<String> nomes = List.of("nome1","nome2","nome3");
        System.out.println(nomes);

        //subscribers , modulos
        var nomesInferencia = new ArrayList<String>();
        System.out.println(nomesInferencia);

        // existe agora uma interface para o garbage collector
        // Novo HttpClient 05/2014 com suporte a Http2


        // textBlocks
        //String txt = """ """;

        //Swicth Expressions
        String nome = "Teste";

        /* não suportado na versão atual da máquina
        switch (nome){

            case "Test","Tes","Teste" -> System.out::println;

        }*/




    }
}
