package repository;

import model.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class QuartoDAO {
    static List<Quarto> quartos = new ArrayList<>();

    public static void salvar(Quarto quartos) {
        QuartoDAO.quartos.add(quartos);
    }

    public static List<Quarto> buscaTodos() {

        if (quartos.isEmpty()) {
            quartos.add(new Quarto(10, TipoQuarto.BLACK_VIP, BigDecimal.valueOf(100), "107", DisponibilidadeQuarto.DISPONIVEL, 2));
        }


        return quartos;
    }

    public static List<Quarto> buscarPorNumQuarto(String numQuarto) {
        buscaTodos();
        List<Quarto> filtrados = new ArrayList<>();
        for (Quarto quarto : quartos) {
            if (quarto.getNumQuarto().equals(numQuarto)) {
                filtrados.add(quarto);
            }
        }
        return filtrados;
    }
}
