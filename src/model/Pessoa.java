package model;

import java.time.LocalDate;

public class Pessoa {
    private Integer ID;
    private String nome;
    private LocalDate dataNascimento;
    private String cpf;
    private String celular;
    private String email;

    public Pessoa(Integer i, String nome, LocalDate dataNascimento, String cpf, String celular, String email) {
        ID = i;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.celular = celular;
        this.email = email;
    }

    public Pessoa(Integer i, String nome, String cpf, String celular, String email) {
        ID = i;
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

    public Integer getID() {
        return ID;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
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
                "I=" + ID +
                ", nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", cpf='" + cpf + '\'' +
                ", celular='" + celular + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
