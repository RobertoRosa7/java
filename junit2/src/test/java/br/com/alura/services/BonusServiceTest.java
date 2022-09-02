package br.com.alura.services;


import br.com.alura.modelos.Funcionario;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BonusServiceTest {

    @Test
    public void bonusDeveriaZeroParaSalarioMaiorQueMil() {
        BonusService bonusService = new BonusService();
        BigDecimal bonus = bonusService.calcBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("25000")));
        assertEquals(BigDecimal.ZERO, bonus);
    }

    @Test
    public void bonusDeveriaZeroParaSalarioMenorQueMil() {
        BonusService bonusService = new BonusService();
        BigDecimal bonus = bonusService.calcBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("2500")));
        assertEquals(new BigDecimal("250").setScale(2, RoundingMode.HALF_UP), bonus);
    }

    @Test
    public void bonusDeveriaZeroParaSalarioEgualMil() {
        BonusService bonusService = new BonusService();
        BigDecimal bonus = bonusService.calcBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("1000")));
        assertEquals(new BigDecimal("100").setScale(2, RoundingMode.HALF_UP), bonus);
    }
}
