package model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Funcionario extends Pessoa {
    private String nome;
    private String cpf;
    private String cargo;
    private BigDecimal salario;

    public Funcionario(Integer i, String nome, LocalDate dataNascimento, String cpf, String celular, String email) {
        super(i, nome, dataNascimento, cpf, celular, email);
    }

    public Funcionario(Integer i, String nome, String cpf, String celular, String email) {
        super(i, nome, cpf, celular, email);
    }

    public Funcionario(String nome, String cpf, String celular, String email) {
        super(nome, cpf, celular, email);
    }


    @Override
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }
}

