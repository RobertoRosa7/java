package br.com.alura.services;

import br.com.alura.modelos.Funcionario;

import java.math.BigDecimal;

public class ReajusteService {
    public void concederReajuste(Funcionario funcionario, Desempenho desempenho) {
        BigDecimal aumento;

        switch (desempenho) {
            case A_DESEJA: {
                aumento = funcionario.getSalario().multiply(new BigDecimal("0.03"));
                break;
            }
            case BOM: {
                aumento = funcionario.getSalario().multiply(new BigDecimal("0.15"));
                break;
            }
            case OTIMO: {
                aumento = funcionario.getSalario().multiply(new BigDecimal("0.20"));
                break;
            }
            default:
                aumento = funcionario.getSalario();
                break;
        }
        funcionario.reajusteSalario(aumento);
    }
}
