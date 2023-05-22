package repository;

import model.Quarto;

import java.util.ArrayList;
import java.util.List;

public class QuartoDAO {
    static List<Quarto> quarto = new ArrayList<>();

    public static void salvar(Quarto quartos) {
        quarto.add(quartos);
    }

    public static List<Quarto> buscaTodos() {
        return quarto;
    }

}
