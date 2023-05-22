package model;

import java.util.ArrayList;
import java.util.List;

public class Servico {
    private Integer codigo;
    private String tipo;
    private Boolean disponibilidade;
    private Double valor;
//    private List<Servico> servicos = new ArrayList<>();

    public Servico(Integer codigo, String tipo, Boolean disponibilidade, Double valor) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.disponibilidade = disponibilidade;
        this.valor = valor;
    }

    public Integer getCodigo() {
        return codigo;
    }


    public String getTipo() {
        return tipo;
    }


    public Boolean getDisponibilidade() {
        return disponibilidade;
    }


    public Double getValor() {
        return valor;
    }

    public double calcularCustoServicos() {
        switch (tipo) {
            case "cafe_da_manha simples":
                return 30.0;
            case "cafe_da_manha premium":
                return 50.0;
            case "almoço":
                return 70.0;
            case "janta":
                return 80.0;
            case "serviço de quarto":

                return 60.0;
            default:
                return 0.0;
        }}

    @Override
    public String toString() {
        return "Servico{" +
                "codigo=" + codigo +
                ", tipo='" + tipo + '\'' +
                ", disponibilidade=" + disponibilidade +
                ", valor=" + valor +
                '}';
    }
}
