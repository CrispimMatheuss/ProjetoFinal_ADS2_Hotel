package repository;


import model.Funcionario;
import model.Manutencao;
import model.OrdemDeServico;
import model.Servico;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ManutencaoDAO {
//    Funcionario funcionario = new Funcionario("jorge aragao", "2345", "99384567", "joao@retro.cpom");
    static List<Manutencao> manutencoes = new ArrayList<>();

    public static List<Manutencao> buscaTodosManutencao() {
        Funcionario funcionario = new Funcionario("jorge aragao", "2345", "99384567", "joao@retro.cpom");
        if (manutencoes.isEmpty()) {
            manutencoes.add(new Manutencao(1, funcionario, LocalDate.now(), "foi concertado o bocal do hall.",
                    new OrdemDeServico(1, " concerto no bocal da lampada do hall de entrada. ", funcionario), TipoManutencao.ELETRICA, StatusManutencao.CONCLUIDA));
            manutencoes.add(new Manutencao(2, funcionario, LocalDate.now(), "foi concertado a rachadura no corredor 3 .",
                    new OrdemDeServico(2, " concerto de rachadura no teto do corredor 3. ", funcionario), TipoManutencao.ESTRUTURAL, StatusManutencao.CONCLUIDA));
            manutencoes.add(new Manutencao(3, funcionario, LocalDate.now(), "foi concertada a torneira com fita veda rosca",
                    new OrdemDeServico(3, " torneira vazando na pia da cozinha interna do restaurante. ", funcionario), TipoManutencao.ESTRUTURAL, StatusManutencao.CONCLUIDA));
            manutencoes.add(new Manutencao(4, funcionario, LocalDate.now(), "foi faxinado e revisado todos os ambientes coletivos",
                    new OrdemDeServico(4, " faxina interna dos ambientes coletivos. ", funcionario), TipoManutencao.LIMPEZA, StatusManutencao.CONCLUIDA));
            manutencoes.add(new Manutencao(5, funcionario, LocalDate.now(), "foi feita limpeza geral da piscina com adicional de cloro.",
                    new OrdemDeServico(5, " limpeza da area da piscina. ", funcionario), TipoManutencao.LIMPEZA, StatusManutencao.CONCLUIDA));
        }
        return manutencoes;
    }

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
