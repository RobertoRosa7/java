package br.com.alura;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestaCurso2 {
    public static void main(String[] args) {
        Curso cusoCollections = new Curso("Dominando as coleções do Java", "Paulo Silveira");
        cusoCollections.adiciona(new Aula("Trabalhando com ArrayList", 25));
        cusoCollections.adiciona(new Aula("Criando uma Aula", 20));
        cusoCollections.adiciona(new Aula("Modelando com coleções", 30));

        List<Aula> aulasImutaveis = cusoCollections.getAulas();
        List<Aula> aulas = new ArrayList<>(aulasImutaveis);
        Collections.sort(aulas);
        System.out.println(cusoCollections.getTempoTotal());
        System.out.println(cusoCollections);
    }
}
