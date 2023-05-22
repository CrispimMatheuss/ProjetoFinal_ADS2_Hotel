package model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Hospedagem {
    private Integer codigo;
    private LocalDate checkin;
    private LocalDate checkout;
    private Hospede hospede;
    private Integer quantidadeDiarias;
    private List<Servico> consumo = new ArrayList<>();
    private BigDecimal valorTotal;
    private Pagamento pagamento;
    private Quarto quarto;


}
