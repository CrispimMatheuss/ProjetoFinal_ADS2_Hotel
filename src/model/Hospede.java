package model;

import model.Pessoa;

import java.time.LocalDate;

public class Hospede extends Pessoa {

    public Hospede(Integer i, String nome, LocalDate dataNascimento, String cpf, String celular, String email) {
        super(i, nome, dataNascimento, cpf, celular, email);
    }

    public Hospede(Integer i, String nome, String cpf, String celular, String email) {
        super(i, nome, cpf, celular, email);
    }

    public Hospede(String nome, String cpf, String celular, String email) {
        super(nome, cpf, celular, email);
    }
}

