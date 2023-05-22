package model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Pagamento {
    private Integer id;
    private char formasDePagamento;
    private LocalDateTime dataHora;
    private BigDecimal valorTotal;
    private BigDecimal descontos;
    private Hospedagem hospedagem;

    public Pagamento(Integer id, char formasDePagamento, LocalDateTime dataHora, BigDecimal valorTotal, BigDecimal descontos, Hospedagem hospedagem) {
        this.id = id;
        this.formasDePagamento = formasDePagamento;
        this.dataHora = dataHora;
        this.valorTotal = valorTotal;
        this.descontos = descontos;
        this.hospedagem = hospedagem;
    }

    public Pagamento(BigDecimal valorPagamento, FormaPagamento formaPagamento) {
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public char getFormasDePagamento() {
        return formasDePagamento;
    }
    public void setFormasDePagamento(char formasDePagamento) {
        this.formasDePagamento = formasDePagamento;
    }
    public LocalDateTime getDataHora() {
        return dataHora;
    }
    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
    public BigDecimal getValorTotal() {
        return valorTotal;
    }
    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }
    public BigDecimal getDescontos() {
        return descontos;
    }
    public void setDescontos(BigDecimal descontos) {
        this.descontos = descontos;
    }
    public Hospedagem getHospedagem() {
        return hospedagem;
    }
    public void setHospedagem(Hospedagem hospedagem) {
        this.hospedagem = hospedagem;
    }

}
