package repository;

import model.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HospedagemDAO {


    static List<Hospedagem> hospedagens = new ArrayList<>();

    public static void salvar(Hospedagem hospedagem) {
        hospedagens.add(hospedagem);
    }

    public static void excluir(Hospedagem hospedagem) {
        hospedagens.remove(hospedagem);
    }


    public static List<Hospedagem> buscaTodos() {
        if (hospedagens.isEmpty()) {
            hospedagens.add(new Hospedagem(10, LocalDate.now(), LocalDate.now(),
                    new Hospede("premium", "5664545", "j54845456445", "joao da silva hotimaiu"),
                    3, new Quarto(1, TipoQuarto.PADRAO_CLASSICO, BigDecimal.valueOf(100.00), "107",
                    DisponibilidadeQuarto.DISPONIVEL, 3)));

            hospedagens.add(new Hospedagem(20, LocalDate.now(), LocalDate.now(),
                    new Hospede("standard", "5664545", "j54845456445", "pedro da silva hotimaiu"),
                    4, new Quarto(1, TipoQuarto.PADRAO_CLASSICO, BigDecimal.valueOf(200.00), "108",
                    DisponibilidadeQuarto.DISPONIVEL, 2)));

            hospedagens.add(new Hospedagem(30, LocalDate.now(), LocalDate.now(),
                    new Hospede("master", "5664545", "j54845456445", "maria da silva hotimaiu"),
                    2, new Quarto(1, TipoQuarto.MASTER_VIP, BigDecimal.valueOf(300.00), "109",
                    DisponibilidadeQuarto.DISPONIVEL, 6)));

            hospedagens.add(new Hospedagem(40, LocalDate.now(), LocalDate.now(),
                    new Hospede("vip", "5664545", "j54845456445", "jose da silva hotimaiu"),
                    3, new Quarto(1, TipoQuarto.VIP, BigDecimal.valueOf(450.00), "110",
                    DisponibilidadeQuarto.DISPONIVEL, 3)));

            hospedagens.add(new Hospedagem(50, LocalDate.now(), LocalDate.now(),
                    new Hospede("premium", "5664545", "j54845456445", "murilo da silva hotimaiu"),
                    5, new Quarto(1, TipoQuarto.STAR_VIP, BigDecimal.valueOf(500.00), "120",
                    DisponibilidadeQuarto.DISPONIVEL, 3)));
        }
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

    public static void removerHospede(Hospede hospedeSelecionado) {

    }
}
