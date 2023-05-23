package model;

import java.math.BigDecimal;

public class Quarto {
    private Integer id;
    private String tipo;
    private BigDecimal valor;
    private String numQuarto;
    private boolean disponibilidade;
    private Integer limitePessoas;

    public Quarto(Integer id, String tipo, BigDecimal valor, String numQuarto, boolean disponibilidade, Integer limitePessoas) {
        this.id = id;
        this.tipo = tipo;
        this.valor = valor;
        this.numQuarto = numQuarto;
        this.disponibilidade = disponibilidade;
        this.limitePessoas = limitePessoas;
    }

    //logica do exibir informacoes
//    public void exibirInformacoes() {
//        System.out.println("Informações detalhadas do quarto:");
//        System.out.println("ID: " + getId());
//        System.out.println("Tipo: " + getTipo());
//        System.out.println("Valor: " + getValor());
//        System.out.println("Disponibilidade: " + (isDisponibilidade() ? "Disponível" : "Indisponível"));
//        System.out.println("Limite de pessoas: " + getLimitePessoas());
//    }
    public enum numQuarto {
        Quarto101("Quarto 101"),
        Quarto102("Quarto 102"),
        Quarto103("Quarto 103"),
        Quarto104("Quarto 104"),
        Quarto105("Quarto 105");
        private String descricao;
        numQuarto(String descricao) {
            this.descricao = descricao;
        }
        public String getDescricao() {
            return descricao;
        }
    }

    public enum tipo {
        PadraoClassico("Quarto 101"),
        Vip("Quarto 102"),
        MasterVip("Quarto 103"),
        StarVip("Quarto 104"),
        BlackVip("Quarto 105");
        private String descricao;
        tipo(String descricao) {
            this.descricao = descricao;
        }
        public String getDescricao() {
            return descricao;
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getNumQuarto() {
        return numQuarto;
    }

    public void setNumQuarto(String numQuarto) {
        this.numQuarto = numQuarto;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public Integer getLimitePessoas() {
        return limitePessoas;
    }

    public void setLimitePessoas(Integer limitePessoas) {
        this.limitePessoas = limitePessoas;
    }
}

