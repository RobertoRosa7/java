package br.com.alura.java.io.teste;

import java.io.Serializable;

public class TesteClient implements Serializable {
    private String name;
    private String cpf;

    TesteClient(String name, String cpf) {
        this.name = name;
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
