package repository;

import model.Hospedagem;
import model.Hospede;
import model.Quarto;

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
            hospedagens.add(new Hospedagem(1, LocalDate.now(), LocalDate.now(),
                    new Hospede("premium", "5664545", "j54845456445", "joao da silva hotimaiu"),
                    3, new Quarto(1, Quarto.TipoQuarto.PADRAO_CLASSICO, BigDecimal.valueOf(100.00), Quarto.NumQuarto.QUARTO101,
                    Quarto.DisponibilidadeQuarto.DISPONIVEL, 3)));

            hospedagens.add(new Hospedagem(2, LocalDate.now(), LocalDate.now(),
                    new Hospede("standard", "5664545", "j54845456445", "pedro da silva hotimaiu"),
                    4, new Quarto(1, Quarto.TipoQuarto.PADRAO_CLASSICO, BigDecimal.valueOf(200.00), Quarto.NumQuarto.QUARTO102,
                    Quarto.DisponibilidadeQuarto.DISPONIVEL, 2)));

            hospedagens.add(new Hospedagem(1, LocalDate.now(), LocalDate.now(),
                    new Hospede("master", "5664545", "j54845456445", "maria da silva hotimaiu"),
                    2, new Quarto(1, Quarto.TipoQuarto.MASTER_VIP, BigDecimal.valueOf(300.00), Quarto.NumQuarto.QUARTO103,
                    Quarto.DisponibilidadeQuarto.DISPONIVEL, 6)));

            hospedagens.add(new Hospedagem(1, LocalDate.now(), LocalDate.now(),
                    new Hospede("vip", "5664545", "j54845456445", "jose da silva hotimaiu"),
                    3, new Quarto(1, Quarto.TipoQuarto.VIP, BigDecimal.valueOf(450.00), Quarto.NumQuarto.QUARTO104,
                    Quarto.DisponibilidadeQuarto.DISPONIVEL, 3)));

            hospedagens.add(new Hospedagem(1, LocalDate.now(), LocalDate.now(),
                    new Hospede("premium", "5664545", "j54845456445", "murilo da silva hotimaiu"),
                    5, new Quarto(1, Quarto.TipoQuarto.STAR_VIP, BigDecimal.valueOf(500.00), Quarto.NumQuarto.QUARTO105,
                    Quarto.DisponibilidadeQuarto.DISPONIVEL, 3)));
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
}
