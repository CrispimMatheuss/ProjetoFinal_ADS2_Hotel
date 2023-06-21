//package model;
//
//
//import repository.StatusManutencao;
//import repository.TipoManutencao;
//
//import java.time.LocalDate;
//
//public class Manutencao {
//    private Integer ID;
//    private Funcionario funcionario;
//    private LocalDate data;
//    private String descricao;
//    private OrdemDeServico OS;
//    private TipoManutencao tipoManutencao;
//    private StatusManutencao status;
//
//    public Manutencao(Integer ID, Funcionario funcionario, LocalDate data, String descricao,
//                      OrdemDeServico OS, TipoManutencao tipoManutencao, StatusManutencao status) {
//        this.ID = ID;
//        this.funcionario = funcionario;
//        this.data = data;
//        this.descricao = descricao;
//        this.OS = OS;
//        this.tipoManutencao = tipoManutencao;
//        this.status = status;
//    }
//
//    public Integer getID() {
//        return ID;
//    }
//
//    public void setID(Integer ID) {
//        this.ID = ID;
//    }
//
//    public Funcionario getFuncionario() {
//        return funcionario;
//    }
//
//    public void setFuncionario(Funcionario funcionario) {
//        this.funcionario = funcionario;
//    }
//
//    public LocalDate getData() {
//        return data;
//    }
//
//    public void setData(LocalDate data) {
//        this.data = data;
//    }
//
//    public String getDescricao() {
//        return descricao;
//    }
//
//    public void setDescricao(String descricao) {
//        this.descricao = descricao;
//    }
//
//    public OrdemDeServico getOS() {
//        return OS;
//    }
//
//    public void setOS(OrdemDeServico OS) {
//        this.OS = OS;
//    }
//
//    public TipoManutencao getTipoManutencao() {
//        return tipoManutencao;
//    }
//
//    public void setTipoManutencao(TipoManutencao tipoManutencao) {
//        this.tipoManutencao = tipoManutencao;
//    }
//
//    public StatusManutencao getStatus() {
//        return status;
//    }
//
//    public void setStatus(StatusManutencao status) {
//        this.status = status;
//    }
//
//    @Override
//    public String toString() {
//        return "Manutencao{" +
//                "ID=" + ID +
//                ", funcionario=" + funcionario +
//                ", data=" + data +
//                ", descricao='" + descricao + '\'' +
//                ", OS=" + OS +
//                ", tipoManutencao=" + tipoManutencao +
//                ", status=" + status +
//                '}';
//    }
//}
//
//
