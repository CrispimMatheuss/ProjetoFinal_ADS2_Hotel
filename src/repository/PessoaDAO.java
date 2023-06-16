package repository;

import model.Funcionario;
import model.Hospede;
import model.Servico;

import java.util.ArrayList;
import java.util.List;

public class PessoaDAO {

    static List<Hospede> hospedes = new ArrayList<>();

    public static void salvar(Hospede hospede) {
        if (hospede.getID() == null) {
            hospede.setId(hospedes.size() + 1);
        } else {
            hospedes.remove(hospede.getID() - 1);
        }
        hospedes.add(hospede);
    }

    public static List<Hospede> buscaTodosh() {
        return hospedes;
    }

    public static List<Hospede> buscarPorNome(String nome) {
        buscaTodosh();
        List<Hospede> hospedeFiltrado = new ArrayList<>();
        for (Hospede hospede : hospedes) {
            if (hospede.getNome() == nome) {
                hospedeFiltrado.add(hospede);
            }
        }
        return hospedeFiltrado;
    }

    public static Object[] findHospedeInArray() {
        List<Hospede> hospedes = buscaTodosh();
        List<String> hospedeDesc = new ArrayList<>();

        for (Hospede hospede : hospedes) {
            hospedeDesc.add(hospede.getNome());
        }
        return hospedeDesc.toArray();
    }

    public static void removerHospede(Hospede hospedeSelecionado) {}

    static List<Funcionario> funcionarios = new ArrayList<>();

    public static void salvar(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public static Object[] findFunciInArray() {
        List<Funcionario> funcionarios2 = buscaTodosf();
        List<String> funciDesc = new ArrayList<>();

        for (Funcionario funcionario : funcionarios) {
            funciDesc.add(funcionario.getNome());
        }

        return funciDesc.toArray();
    }

    public static List<Funcionario> buscaTodosf() {
        return funcionarios;
    }

    public static List<Funcionario> buscarPorNomef(String nome) {
        buscaTodosf();
        List<Funcionario> funcionarioFiltrado = new ArrayList<>();
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getNome() == nome) {
                funcionarioFiltrado.add(funcionario);
            }
        }
        return funcionarioFiltrado;
    }

    public static void removerFuncionario(Funcionario funcionarioSelecionado) {}
}
