package repository;
import model.Hospede;
import model.Pessoa;
import java.util.ArrayList;
import java.util.List;

    public class PessoaDAO {

        static List<Hospede> hospedes = new ArrayList<>();

        public static void salvar(Hospede hospede) {
            hospedes.add(hospede);
        }

        public static List<Hospede> buscaTodos() {
            return hospedes;
        }

    }
