package repository;

import model.Manutencao;

import java.util.ArrayList;
import java.util.List;

public class ManutencaoDAO {
    static List<Manutencao> manutencoes = new ArrayList<>();

    public static void salvar(Manutencao manutencao) {
        manutencoes.add(manutencao);
    }
    public static void excluir(Manutencao manutencao) {
        manutencoes.remove(manutencao);
    }
    public static List<Manutencao> buscaTodos() {
        return manutencoes;
    }
}
