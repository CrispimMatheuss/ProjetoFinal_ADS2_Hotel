package repository;
import model.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class FuncionarioDAO {
    private static List<Funcionario> funcionarios;
    public static List<Funcionario> todosFuncionarios() {
        if (funcionarios.isEmpty()) {
            funcionarios.add(new Funcionario(1, "Maria Silva","987.654.321-09", "+55 11 98765-4321", "marisilva@gmail.com" ));
            funcionarios.add(new Funcionario(2, "João Santos","111.222.333-44", "+55 21 91234-5678", "joaosantos@gmail.com" ));
            funcionarios.add(new Funcionario(3, "Ana Oliveira","555.666.777-88", "+55 47 99876-5432", "anaoliveira@gmail.com" ));
            funcionarios.add(new Funcionario(4, "Pedro Rodrigues","999.888.777-66", "+55 31 87654-3210", "pedrorodrigues@gmail.com" ));
            funcionarios.add(new Funcionario(5, "Sofia Almeida","444.333.222-11", "+55 82 94567-8901", "sofiaalmeida@gmail.com" ));
        }
        return funcionarios;
    }
}
