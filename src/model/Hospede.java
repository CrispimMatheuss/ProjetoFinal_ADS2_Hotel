package model;

import java.time.LocalDate;

public class Hospede extends Pessoa {
    private String classificacao;
    public Hospede(Integer i, String nome, LocalDate dataNascimento, String cpf, String celular, String email) {
        super(i, nome, cpf, celular, email);
    }
    public Hospede(Integer i, String nome, String cpf, String celular, String email) {
        super(i, nome, cpf, celular, email);
    }
    public Hospede(String nome, String cpf, String celular, String email) {
        super(nome, cpf, celular, email);
    }

    public String getClassificacao() {
        return classificacao;
    }
    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }


    @Override
    public void setId(Integer id) {
        super.setId(id);
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


    @Override
    public void exibirInformacoes() {
        System.out.println("Informações do Hóspede:");
        System.out.println("Nome: " + getNome());
        System.out.println("CPF: " + getCpf());
        System.out.println("Celular: " + getCelular());
        System.out.println("Email: " + getEmail());
    }


}
