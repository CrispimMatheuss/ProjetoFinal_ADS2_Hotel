package model;
import java.time.LocalDate;
public class Funcionario extends Pessoa {
    private String cpf;
    private String cargo;
    private double salario;
    public String getCpf() {
        return cpf;
    }

    @Override
    public void setId(int i) {

    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getCargo() { return cargo; }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public void exibirInformacoes() {
        System.out.println("Informações do Funcionário:");
        System.out.println("Nome: " + getNome());
        System.out.println("CPF: " + getCpf());
        System.out.println("Cargo: " + getCargo());
        System.out.println("Salário: " + getSalario());
        System.out.println("Celular: " + getCelular());
        System.out.println("Email: " + getEmail());    }

    public Funcionario(Integer i, String nome, String cpf, String celular, String email) {
        super(i, nome, cpf, celular, email);
    }

    public Funcionario(String nome, String cpf, String celular, String email) {
        super(nome, cpf, celular, email);
    }
}

