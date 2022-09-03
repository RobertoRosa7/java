package br.com.alura;

public class TestaCursoComAluno {
    public static void main(String[] args) {
        Curso curso = new Curso("Dominando as coleções do Java", "Paulo Silveira");
        curso.adiciona(new Aula("Trabalhando com ArrayList", 25));
        curso.adiciona(new Aula("Criando uma Aula", 20));
        curso.adiciona(new Aula("Modelando com coleções", 30));

        Aluno aluno = new Aluno("Rodrigo Turini", 34223);
        Aluno aluno2 = new Aluno("Guilherme Silveira", 34213);
        Aluno aluno3 = new Aluno("Mauricio Aniche", 34222);
        Aluno Roberto = new Aluno("Rodrigo Turini", 34223);

        curso.matricula(aluno);
        curso.matricula(aluno2);
        curso.matricula(aluno3);

        System.out.println(curso.estaMaticulado(aluno));
        System.out.println(aluno.hashCode() == Roberto.hashCode());
        System.out.println(aluno.equals(Roberto));

    }
}
