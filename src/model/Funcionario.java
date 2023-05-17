package model;

import java.time.LocalDate;

public class Funcionario extends Pessoa {

    public Funcionario(Integer i, String nome, LocalDate dataNascimento, String cpf, String celular, String email) {
        super(i, nome, dataNascimento, cpf, celular, email);
    }

    public Funcionario(Integer i, String nome, String cpf, String celular, String email) {
        super(i, nome, cpf, celular, email);
    }

    public Funcionario(String nome, String cpf, String celular, String email) {
        super(nome, cpf, celular, email);
    }
}

