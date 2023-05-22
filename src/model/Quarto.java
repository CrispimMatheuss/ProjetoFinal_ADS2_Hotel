package model;

public class Quarto {
    private Integer id;
    private String tipo;
    private Integer quantidadeCamas;
    private Double valor;
    private boolean disponibilidade;
    private Integer limitePessoas;

    public Quarto(Integer id, String tipo, Integer quantidadeCamas, Double valor, boolean disponibilidade, Integer limitePessoas) {
        this.id = id;
        this.tipo = tipo;
        this.quantidadeCamas = quantidadeCamas;
        this.valor = valor;
        this.disponibilidade = disponibilidade;
        this.limitePessoas = limitePessoas;
    }
    public Integer getId() {
        return id;
    }
    public String getTipo() {
        return tipo;
    }
    public Integer getQuantidadeCamas() {
        return quantidadeCamas;
    }
    public Double getValor() {
        return valor;
    }
    public boolean isDisponibilidade() {
        return disponibilidade;
    }
    public Integer getLimitePessoas() {
        return limitePessoas;
    }
    @Override
    public String toString() {
        return "Quarto{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                ", quantidadeCamas=" + quantidadeCamas +
                ", valor=" + valor +
                ", disponibilidade=" + disponibilidade +
                ", limitePessoas=" + limitePessoas +
                '}';
    }
}