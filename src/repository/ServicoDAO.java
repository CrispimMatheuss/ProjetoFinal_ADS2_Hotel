package repository;
import model.Servico;
import java.util.ArrayList;
import java.util.List;
public class ServicoDAO {

    static List<Servico> servicos = new ArrayList<>();


    public ServicoDAO() {

        if(servicos.isEmpty()){
            servicos.add(new Servico(1,"Cafe da manhã simples",20.00));
            servicos.add(new Servico(2,"Cafe da manhã premium",40.00));
            servicos.add(new Servico(3,"Almoço",60.00));
            servicos.add(new Servico(4,"Janta",70.00));
            servicos.add(new Servico(5,"Serviço de quarto",50.00));
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

