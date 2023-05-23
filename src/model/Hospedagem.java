package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Hospedagem {
    private Integer codigo;
    private LocalDate checkin;
    private LocalDate checkout;
    private Hospede hospede;
    private Integer quantidadeDiarias;
    private Double valorTotal;
    private Double valorDiaria;
    private Pagamento pagamento;
    private Quarto quarto;
    private List<Servico> servicos = new ArrayList<>();

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

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(Double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public void addServico(Servico servico) {
        this.servicos.add(servico);
    }

    private void removeServico(Servico servico) {
        this.servicos.remove(servico);
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public double calcularCustoTotal() {
        double custoTotal = 0.0;
        for (Servico servico : servicos) {
            custoTotal += servico.getValor();
        }
        return custoTotal;
    }
}
