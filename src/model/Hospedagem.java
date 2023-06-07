package model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Hospedagem {
    private Integer codigo;
    private LocalDate checkin;
    private LocalDate checkout;
    private Hospede hospede;
    private Integer quantidadeDiarias;
    private Quarto quarto;
    private Servico servico;
    private BigDecimal valorConsumo;
    private BigDecimal valorTotalHospedagem;


    public Hospedagem(Integer codigo, LocalDate checkin, LocalDate checkout, Hospede hospede, Integer quantidadeDiarias, Quarto quarto, Servico servico) {
        this.codigo = codigo;
        this.checkin = checkin;
        this.checkout = checkout;
        this.hospede = hospede;
        this.quantidadeDiarias = quantidadeDiarias;
        this.quarto = quarto;
        this.servico = servico;
    }

    public BigDecimal calculaValorConsumo(){
        BigDecimal valCons = this.servico.getValor();
        this.valorConsumo = valCons;
        return valCons;


    }
    public BigDecimal calculaValorTotalHospedagem(){
        BigDecimal consumoLocal =this.valorConsumo;
        BigDecimal valorDiaria = this.quarto.getValor();

        BigDecimal valorTot = consumoLocal.add(valorDiaria.multiply(BigDecimal.valueOf(quantidadeDiarias)));
        this.valorTotalHospedagem = valorTot;
        return valorTot;
    }
    public void addServico(Servico servico){

    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public LocalDate getCheckin() {
        return checkin;
    }

    public void setCheckin(LocalDate checkin) {
        this.checkin = checkin;
    }

    public LocalDate getCheckout() {
        return checkout;
    }

    public void setCheckout(LocalDate checkout) {
        this.checkout = checkout;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }

    public Integer getQuantidadeDiarias() {
        return quantidadeDiarias;
    }

    public void setQuantidadeDiarias(Integer quantidadeDiarias) {
        this.quantidadeDiarias = quantidadeDiarias;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public BigDecimal getValorTotalHospedagem() {
        return valorTotalHospedagem;
    }

    public void setValorTotalHospedagem(BigDecimal valorTot) {
        this.valorTotalHospedagem = valorTot;
    }

    @Override
    public String toString() {
        return "Hospedagem{" +
                "codigo=" + codigo +
                ", checkin=" + checkin +
                ", checkout=" + checkout +
                ", hospede=" + hospede +
                ", quantidadeDiarias=" + quantidadeDiarias +
                ", quarto=" + quarto +
                ", consumo=" + servico +
                ", valorTotalHospedagem=" + valorTotalHospedagem +
                '}';
    }
}


