package model;
import model.Pessoa;
import java.time.LocalDate;
public class Hospede extends Pessoa {
    private String classificacao;
    private String cpf;
    private String email;
    private String telefone;

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
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

    @Override
    public void setId(int i) {

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

    public Hospede(Integer i, String classificacao, LocalDate dataNascimento, String cpf, String celular, String email) {
        super(i, classificacao, dataNascimento, cpf, celular, email);
    }
    @Override
    public void exibirInformacoes() {
        System.out.println("Informações do Hóspede:");
        System.out.println("Nome: " + getNome());
        System.out.println("CPF: " + getCpf());
        System.out.println("Data de Nascimento: " + getDataNascimento());
        System.out.println("Telefone: " + getTelefone());
        System.out.println("Email: " + getEmail());
    }
    public Hospede(Integer i, String classificacao, String cpf, String celular, String email) {
        super(i, classificacao, cpf, celular, email);
    }
    public Hospede(String classificacao, String cpf, String celular, String email) {
        super(classificacao, cpf, celular, email);
    }
}