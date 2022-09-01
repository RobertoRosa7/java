package br.com.alura;

public class TestaCurso {
    public static void main(String[] args) {
        Curso curso = new Curso("Dominando as coleções do Java", "Paulo Silveira");
        curso.adiciona(new Aula("Trabalhando com ArrayList", 25));
        curso.adiciona(new Aula("Criando uma Aula", 20));
        curso.adiciona(new Aula("Modelando com coleções", 30));

        System.out.println(curso.getAulas());
    }
}
