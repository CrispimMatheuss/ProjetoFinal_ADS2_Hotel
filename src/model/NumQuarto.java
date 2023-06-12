package model;
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
    }


}
