package repository;

public enum TipoManutencao {
    ELETRICA(1,"manutenção da parte elétrica"),
    ESTRUTURAL(2,"manutenção estrutural"),
    LIMPEZA(3,"limpeza e faxinas");

    private int valor;
    private String descricao;

    TipoManutencao(int valor,String descricao){
        this.valor = valor;
        this.descricao= descricao;

    }

    public int getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }
}
