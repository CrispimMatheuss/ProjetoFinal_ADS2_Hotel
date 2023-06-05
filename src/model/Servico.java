package model;

import java.util.ArrayList;
import java.util.List;

public class Servico {
    private Integer codigo;
    private String tipo;
    private Boolean disponibilidade;
    private Double valor;
//    private List<Servico> servicos = new ArrayList<>();

    public Servico(Integer codigo, String tipo, Double valor) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.disponibilidade = true;
        this.valor = valor;
    }

    public Servico(String tipo, Double valor) {
        this.tipo = tipo;
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

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

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
