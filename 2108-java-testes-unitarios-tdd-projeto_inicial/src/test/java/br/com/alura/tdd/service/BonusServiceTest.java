package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.modelo.ReajusteSalarialException;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class BonusServiceTest {

    @Test
    public void bonusDeveriaSerZeroParaFuncionarioComSalarioAlto(){

        BonusService service = new BonusService();
        assertThrows(
                ReajusteSalarialException.class,
                () -> service.calcularBonus(
                        new Funcionario(
                                "Antony",
                                LocalDate.now(),
                                new BigDecimal("42000")
                        )
                )
        );

    }

    @Test
    public void bonusDeveriaSerZeroParaFuncionarioComSalarioAltoOutraManeira(){

        BonusService service = new BonusService();

        try {
            service.calcularBonus(
                    new Funcionario(
                            "Antony",
                            LocalDate.now(),
                            new BigDecimal("42000")
                    ));
            fail("Deveria ter sido lançado uma ReajusteSalarialException");
        }
        catch (ReajusteSalarialException reajusteSalarialException){
            assertEquals(
                    "O salario do funcionario nao pode " +
                            "ser maior do que 10000 reais.",
                            reajusteSalarialException.getMessage()
            );
        }

    }

    @Test
    public void bonusDeveriaSer10PorCentoDoSalario(){

        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario(
                "Antony",
                LocalDate.now(),
                new BigDecimal("4200")));

        assertEquals(new BigDecimal("420.00"), bonus);

    }

    @Test
    public void bonusDeveriaSer10PorCentoParaSalarioDeExatamente10000(){

        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario(
                "Antony",
                LocalDate.now(),
                new BigDecimal("10000")));

        assertEquals(new BigDecimal("1000.00"), bonus);

    }






}