package model;

import java.time.LocalDateTime;

public class Pagamento {
    private Integer id;
    private char formasDePagamento;
    private LocalDateTime dataHora;
    private Double valorTotal;
    private Double descontos;
     private Hospedagem hospedagem;
}
