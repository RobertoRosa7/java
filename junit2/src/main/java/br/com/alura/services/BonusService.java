package br.com.alura.services;

import br.com.alura.modelos.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BonusService {
    public BigDecimal calcBonus(Funcionario funcionario) {
        BigDecimal valor = funcionario.getSalario().multiply(new BigDecimal("0.1"));
        return this.comparaValorMaiorQueZero(valor) ? BigDecimal.ZERO : valor.setScale(2, RoundingMode.HALF_UP);
    }

    private boolean comparaValorMaiorQueZero(BigDecimal valor) {
        return valor.compareTo(new BigDecimal("1000")) > 0;
    }
}
