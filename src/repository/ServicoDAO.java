package repository;
import model.Servico;
import java.util.ArrayList;
import java.util.List;
public class ServicoDAO {

    static List<Servico> servicos = new ArrayList<>();


    public ServicoDAO() {

        if(servicos.isEmpty()){
            servicos.add(new Servico(1,"Cafe da manhã",true,20.00));
            servicos.add(new Servico(1,"Cafe da manhã",true,20.00));
            servicos.add(new Servico(1,"Cafe da manhã",true,20.00));
            servicos.add(new Servico(1,"Cafe da manhã",true,20.00));
            servicos.add(new Servico(1,"Cafe da manhã",true,20.00));
        }

    }

    public static void adicionarServico(Servico servico) {
        servicos.add(servico);
    }

    public void excluir(Servico servico) {
        servicos.remove(servico);
    }

    public static List<Servico> buscaTodos() {
        return servicos;
    }
}

