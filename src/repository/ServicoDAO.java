package repository;

import model.EscolheServico;
import model.Hospedagem;
import model.Servico;

import java.util.ArrayList;
import java.util.List;

public class ServicoDAO {

    static List<Servico> servicos = new ArrayList<>();


    public static void setarCodigo(Servico servico) {
        servico.setCodigo(servicos.size() + 1);
        servicos.add(servico);
    }

    public static void salvar(Servico servico) {
        servicos.add(servico);
    }

    public void excluir(Servico servico) {
        servicos.remove(servico);
    }

    public static List<Servico> buscaTodos() {
        if (servicos.isEmpty()) {
            servicos.add(new Servico(1, "Cafe da manhã simples", 20.00));
            servicos.add(new Servico(2, "Cafe da manhã premium", 40.00));
            servicos.add(new Servico(3, "Almoço", 60.00));
            servicos.add(new Servico(4, "Janta", 70.00));
            servicos.add(new Servico(5, "Serviço de quarto", 50.00));
        }
        return servicos;
    }

    public static Object[] findServicosInArray() {
        List<Servico> servicos = buscaTodos();
        List<String> servicosDescricao = new ArrayList<>();

        for (Servico servico : servicos) {
            servicosDescricao.add(servico.getTipo());
        }

        return servicosDescricao.toArray();
    }

    public static List<Servico> buscarPorTipo(String tipo) {
        List<Servico> servicoFiltradas = new ArrayList<>();
        for (Servico servico : servicos) {
            if (servico.getTipo() == tipo) {
                servicoFiltradas.add(servico);
            }
        }
        return servicoFiltradas;
    }
}

