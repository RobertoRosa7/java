package br.com.alura.loja.model;

import javax.persistence.*;


@Entity()
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated
    private PersonalData personalData;


    public Client(String name, String cpf) {
        this.personalData = new PersonalData(name, cpf);
    }

    public Client() {

    }

    public String getName() {
        return this.personalData.getName();
    }

    public void setName(String name) {
        this.personalData.setName(name);
    }

    public String getCpf() {
        return this.personalData.getCpf();
    }

    public void setCpf(String cpf) {
        this.personalData.setCpf(cpf);
    }
}
