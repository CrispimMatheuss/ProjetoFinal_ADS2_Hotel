package repository;

import model.Funcionario;
import model.Hospede;

import java.util.ArrayList;
import java.util.List;

public class PessoaDAO {

    static List<Hospede> hospedes = new ArrayList<>();

    public static void salvar(Hospede hospede) {
        hospede.setId(hospedes.size() + 1);
        hospedes.add(hospede);
    }

    public static List<Hospede> buscaTodosh() {
        return hospedes;
    }


    static List<Funcionario> funcionarios = new ArrayList<>();

    public static void salvar(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public static List<Funcionario> buscaTodosf() {
        return funcionarios;
    }

}
