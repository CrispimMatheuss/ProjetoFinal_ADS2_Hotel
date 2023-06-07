package model;

import java.math.BigDecimal;

public class Quarto {
    private Integer id;
    private TipoQuarto tipoQuarto;
    private BigDecimal valor;
    private NumQuarto numQuarto;
    private DisponibilidadeQuarto disponibilidade;
    private Integer limitePessoas;

    public Quarto(Integer id, TipoQuarto tipoQuarto, BigDecimal valor, NumQuarto numQuarto,
                  DisponibilidadeQuarto disponibilidade, Integer limitePessoas) {
        this.id = id;
        this.tipoQuarto = tipoQuarto;
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

    public enum DisponibilidadeQuarto {
        DISPONIVEL("Disponível"),
        INDISPONIVEL("Indisponível");

        private String descricao;

        DisponibilidadeQuarto(String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao() {
            return descricao;
        }
    }

    public DisponibilidadeQuarto getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(DisponibilidadeQuarto disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public enum TipoQuarto {
        PADRAO_CLASSICO("Padrão Clássico"),
        VIP("VIP"),
        MASTER_VIP("Master VIP"),
        STAR_VIP("Star VIP"),
        BLACK_VIP("Black VIP");
        private String descricao;
        TipoQuarto(String descricao) {
            this.descricao = descricao;
        }
        public String getDescricao() {
            return descricao;
        }}
    public enum NumQuarto {
        QUARTO101("Quarto 101"),
        QUARTO102("Quarto 102"),
        QUARTO103("Quarto 103"),
        QUARTO104("Quarto 104"),
        QUARTO105("Quarto 105");
        private String descricao;
        NumQuarto(String descricao) {
            this.descricao = descricao;
        }
        public String getDescricao() {
            return descricao;
        }}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TipoQuarto getTipoQuarto() {
        return tipoQuarto;
    }

    public void setTipoQuarto(TipoQuarto tipoQuarto) {
        this.tipoQuarto = tipoQuarto;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public NumQuarto getNumQuarto() {
        return numQuarto;
    }

    public void setNumQuarto(NumQuarto numQuarto) {
        this.numQuarto = numQuarto;
    }
    public Integer getLimitePessoas() {
        return limitePessoas;
    }

    public void setLimitePessoas(Integer limitePessoas) {
        this.limitePessoas = limitePessoas;

    }

    @Override
    public String toString() {
        return "Quarto{" +
                "id=" + id +
                ", tipoQuarto=" + tipoQuarto +
                ", valor=" + valor +
                ", numQuarto=" + numQuarto +
                ", disponibilidade=" + disponibilidade +
                ", limitePessoas=" + limitePessoas +
                '}';
    }
}