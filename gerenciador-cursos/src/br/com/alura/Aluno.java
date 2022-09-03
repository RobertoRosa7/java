package br.com.alura;

import java.util.Objects;

public class Aluno {

    private String name;
    private int numeroMatricula;

    public Aluno(String name, int numeroMatricula) {
        if (name == null) {
            throw new NullPointerException("Nome não pode ser null");
        }
        this.name = name;
        this.numeroMatricula = numeroMatricula;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Aluno aluno)) return false;
        return getNumeroMatricula() == aluno.getNumeroMatricula() && getName().equals(aluno.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getNumeroMatricula());
    }

    @Override
    public String toString() {
        return "{" + "name:'" + name + '\'' + ", numeroMatricula:" + numeroMatricula + '}';
    }

    public int getNumeroMatricula() {
        return numeroMatricula;
    }
}
