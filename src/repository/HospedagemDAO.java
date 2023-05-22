package repository;

import model.Hospedagem;

import java.util.ArrayList;
import java.util.List;

public class HospedagemDAO {

    static List<Hospedagem> hospedagens = new ArrayList<>();

    public static void salvar(Hospedagem hospedagem) {
        hospedagens.add(hospedagem);
    }

    public static List<Hospedagem> buscaTodos() {
        return hospedagens;
    }

    public static Object[] findhospedagensInArray() {
        List<Hospedagem> hospedagens = buscaTodos();
        List<Integer> hospedagemCodigo = new ArrayList<>();

        for (Hospedagem hospedagem : hospedagens) {
            hospedagemCodigo.add(hospedagem.getCodigo());
        }

        return hospedagemCodigo.toArray();
    }

    public static List<Hospedagem> buscarPorCodigo(Integer codigo) {
        List<Hospedagem> hospedagemFiltradas = new ArrayList<>();
        for (Hospedagem hospedagem : hospedagens) {
            if (hospedagem.getCodigo() == codigo) {
                hospedagemFiltradas.add(hospedagem);
            }
        }
        return hospedagemFiltradas;
    }
}
