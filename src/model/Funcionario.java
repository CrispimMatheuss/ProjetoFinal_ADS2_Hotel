package model;
import java.math.BigDecimal;
import java.time.LocalDate;
public class Funcionario extends Pessoa {
    private String cargo;
    private BigDecimal salario;
    public Funcionario(Integer i, String nome, LocalDate dataNascimento, String cpf, String celular, String email) {
        super(i, nome,  cpf, celular, email);
    }
    public Funcionario(Integer i, String nome, String cpf, String celular, String email) {
        super(i, nome, cpf, celular, email);
    }
    public Funcionario(String nome, String cpf, String celular, String email) {
        super(nome, cpf, celular, email);
    }
    public String getCargo() { return cargo; }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    public BigDecimal getSalario() {
        return salario;
    }
    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }
    @Override
    public void exibirInformacoes() {
        System.out.println("Informações do Funcionário:");
        System.out.println("Nome: " + getNome());
        System.out.println("CPF: " + getCpf());
        System.out.println("Cargo: " + getCargo());
        System.out.println("Salário: " + getSalario());
        System.out.println("Celular: " + getCelular());
        System.out.println("Email: " + getEmail());    }
    @Override public void setId(int i) {}
}