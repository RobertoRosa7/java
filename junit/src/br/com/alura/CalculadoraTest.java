package br.com.alura;

import org.junit.jupiter.api.Test;

public class CalculadoraTest {

    @Test
    public void deveriaSomarDoisNumerosPositivos() {
        Calculadora calculadora = new Calculadora();
        int somar = calculadora.somar(2, 5);
    }
}
