package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.*;


import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReajusteServiceTest {

   public ReajusteService reajusteService;
   public Funcionario funcionario;

   @BeforeEach // antes de cada teste execute isso
   public void inicializar(){
       System.out.println("Antes de Cada Teste");
       this.reajusteService = new ReajusteService();
       this.funcionario = new Funcionario(
               "Antony",
               LocalDate.now(),
               new BigDecimal("1000")
       );
   }

    @Test
    public void reajusteDeveriaSerDe3PorCentoQuandoDesempenhoForADesejar(){

        this.reajusteService.concederReajuste(funcionario,Desempenho.A_DESEJAR);
        assertEquals(new BigDecimal("1030.00"),funcionario.getSalario());

    }

    @Test
    public void reajusteDeveriaSerDe15PorCentoQuandoDesempenhoForBom(){

        this.reajusteService.concederReajuste(funcionario,Desempenho.BOM);
        assertEquals(new BigDecimal("1150.00"),funcionario.getSalario());

    }

    @Test
    public void reajusteDeveriaSerDe20PorCentoQuandoDesempenhoForOtimo(){

        this.reajusteService.concederReajuste(funcionario,Desempenho.OTIMO);
        assertEquals(new BigDecimal("1200.00"),funcionario.getSalario());

    }

    @AfterEach
    public void depoisDeCadateste(){

       System.out.println("Faça Algo");

    }

    @BeforeAll
    public static void antesDeTodosOsTestes(){
       System.out.println("Antes de todos os testes");
    }

    @AfterAll
    public static void depoisDeTodosOsTestes(){
        System.out.println("Depois de odos os testes");
    }


}