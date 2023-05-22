<<<<<<< HEAD
package repository;

import model.Servico;

import java.util.ArrayList;
import java.util.List;

public class ConsumoDAO {
    static List<Servico> servicos = new ArrayList<>();

    public static void adicionarServico(Servico servico) {
        servicos.add(servico);
    }

    public void excluir(Servico servico) {
        servicos.remove(servico);
    }

    public static List<Servico> buscaTodos() {
        return servicos;
    }

    public double calcularCustoTotal() {
        double custoTotal = 0.0;
        for (Servico servico : servicos) {
            custoTotal += servico.calcularCustoServicos();
        }
        return custoTotal;
    }


}
=======
package repository;

import model.Servico;

import java.util.ArrayList;
import java.util.List;

public class ConsumoDAO {
    static List<Servico> servicos = new ArrayList<>();

    public static void adicionarServico(Servico servico) {
        servicos.add(servico);
    }

 public void excluir(Servico servico) {
 servicos.remove(servico);
 }

    public static List<Servico> buscaTodos() {
        return servicos;
    }

    public double calcularCustoTotal() {
        double custoTotal = 0.0;
        for (Servico servico : servicos) {
            custoTotal += servico.calcularCustoServicos();
        }
        return custoTotal;
    }


}
>>>>>>> origin/master
