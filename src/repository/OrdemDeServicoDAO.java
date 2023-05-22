package repository;

import model.OrdemDeServico;

import java.util.ArrayList;
import java.util.List;

public class OrdemDeServicoDAO {
    static List<OrdemDeServico> OS = new ArrayList<>();

    public static void salvar(OrdemDeServico ordemDeServico) {
        OS.add(ordemDeServico);
    }
    public static void excluir(OrdemDeServico ordemDeServico) {
        OS.remove(ordemDeServico);
    }
    public static List<OrdemDeServico> buscaTodos() {
        return OS;
    }
}
