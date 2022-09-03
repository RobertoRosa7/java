package br.com.alura.services;

import br.com.alura.modelos.Funcionario;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReajusteServiceTest {

    @Test
    public void reajusteDeveSerTresPorcento() {
        ReajusteService service = new ReajusteService();
        Funcionario funcionario = new Funcionario("Ana", LocalDate.now(), new BigDecimal("1000"));
        service.concederReajuste(funcionario, Desempenho.A_DESEJA);

        assertEquals(new BigDecimal("1030").setScale(2, RoundingMode.HALF_UP), funcionario.getSalario());
    }

    @Test
    public void reajusteDeveSerQuinzePorcento() {
        ReajusteService service = new ReajusteService();
        Funcionario funcionario = new Funcionario("Ana", LocalDate.now(), new BigDecimal("1000"));
        service.concederReajuste(funcionario, Desempenho.BOM);

        assertEquals(new BigDecimal("1150").setScale(2, RoundingMode.HALF_UP), funcionario.getSalario());
    }

    @Test
    public void reajusteDeveSerVintePorcento() {
        ReajusteService service = new ReajusteService();
        Funcionario funcionario = new Funcionario("Ana", LocalDate.now(), new BigDecimal("1000"));
        service.concederReajuste(funcionario, Desempenho.OTIMO);

        assertEquals(new BigDecimal("1200").setScale(2, RoundingMode.HALF_UP), funcionario.getSalario());
    }
}
