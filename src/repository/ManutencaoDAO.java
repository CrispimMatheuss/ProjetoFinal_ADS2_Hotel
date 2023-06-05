package repository;



import model.Funcionario;
import model.Manutencao;
import model.OrdemDeServico;
import model.Servico;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ManutencaoDAO {

    Funcionario funcionario = new Funcionario("jorge aragao","2345","99384567","joao@retro.cpom");
    public ManutencaoDAO() {

        if(manutencoes.isEmpty()){
            manutencoes.add(new Manutencao(1,funcionario,LocalDate.now(),"foi concertado o bocal do hall.",
                    new OrdemDeServico(1," concerto no bocal da lampada do hall de entrada. ",funcionario), TipoManutencao.ELETRICA,StatusManutencao.CONCLUIDA));
            manutencoes.add(new Manutencao(1,funcionario,LocalDate.now(),"foi concertado o bocal do hall.",
                    new OrdemDeServico(1," concerto no bocal da lampada do hall de entrada. ",funcionario), TipoManutencao.ELETRICA,StatusManutencao.CONCLUIDA));
            manutencoes.add(new Manutencao(1,funcionario,LocalDate.now(),"foi concertado o bocal do hall.",
                    new OrdemDeServico(1," concerto no bocal da lampada do hall de entrada. ",funcionario),TipoManutencao.ELETRICA,StatusManutencao.CONCLUIDA));
            manutencoes.add(new Manutencao(1,funcionario,LocalDate.now(),"foi concertado o bocal do hall.",
                    new OrdemDeServico(1," concerto no bocal da lampada do hall de entrada. ",funcionario),TipoManutencao.ELETRICA,StatusManutencao.CONCLUIDA));
            manutencoes.add(new Manutencao(1,funcionario,LocalDate.now(),"foi concertado o bocal do hall.",
                    new OrdemDeServico(1," concerto no bocal da lampada do hall de entrada. ",funcionario),TipoManutencao.ELETRICA,StatusManutencao.CONCLUIDA));
        }

    }
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
