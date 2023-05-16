package model;

import java.time.LocalDate;
public class Consumo {
    private Integer codigo;
    private Servico servico;
    private Hospedagem hospedagem;
    private Double valorTotal;
    private LocalDate data;

    public Consumo(Integer codigo, Servico servico, Hospedagem hospedagem, Double valorTotal, LocalDate data) {
        this.codigo = codigo;
        this.servico = servico;
        this.hospedagem = hospedagem;
        this.valorTotal = valorTotal;
        this.data = data;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public Servico getServico() {
        return servico;
    }

    public Hospedagem getHospedagem() {
        return hospedagem;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public LocalDate getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Consumo{" +
                "codigo=" + codigo +
                ", servico=" + servico +
                ", hospedagem=" + hospedagem +
                ", valorTotal=" + valorTotal +
                ", data=" + data +
                '}';
    }
}
