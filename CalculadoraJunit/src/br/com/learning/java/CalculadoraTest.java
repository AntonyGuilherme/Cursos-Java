package br.com.learning.java;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculadoraTest {

    @Test
    public void somaNumerosPositivos(){
         Calculadora calculadora = new Calculadora();
         int soma = calculadora.somar(10,20);
         Assertions.assertEquals(30,soma);

    }


}
