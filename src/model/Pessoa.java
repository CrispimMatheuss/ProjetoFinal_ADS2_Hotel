package model;

import java.time.LocalDate;

public abstract class Pessoa {
    private Integer id;
    private String nome;
    private String cpf;
    private String celular;
    private String email;

    public Pessoa(Integer i, String nome, String cpf, String celular, String email) {
        id = i;
        this.nome = nome;
        this.cpf = cpf;
        this.celular = celular;
        this.email = email;
    }

    public Pessoa(String nome, String cpf, String celular, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.celular = celular;
        this.email = email;
    }

    public Integer getI() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getCelular() {
        return celular;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "I=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", celular='" + celular + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public abstract void setId(int i);
}
