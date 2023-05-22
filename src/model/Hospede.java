package model;

import model.Pessoa;

import java.time.LocalDate;

public class Hospede extends Pessoa {

    private String nome;
    private String cpf;
    private String email;
    private String telefone;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void fazerCheckIn() {
        // Lógica para realizar o check-in do hóspede
    }

    public void fazerCheckOut() {
        // Lógica para realizar o check-out do hóspede
    }

    public void solicitarServico(String servico) {
        // Lógica para registrar o pedido de um serviço pelo hóspede
    }

    public void registrarPagamento(double valor) {
        // Lógica para registrar um pagamento realizado pelo hóspede
    }

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

