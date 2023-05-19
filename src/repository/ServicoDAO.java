package repository;
import model.Servico;
import java.util.ArrayList;
import java.util.List;
public class ServicoDAO {

        static List<Servico> servicos = new ArrayList<>();

        public static void salvar(Servico servico) {
            servicos.add(servico);
        }
        public static void excluir(Servico servico) {
            servicos.remove(servico);
        }
        public static List<Servico> buscaTodos() {
            return servicos;
        }
    }

