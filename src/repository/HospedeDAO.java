package repository;
import model.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static repository.PessoaDAO.hospedes;

public class HospedeDAO {
    public static List<Hospede> todosHospedes() {
        if (hospedes.isEmpty()) {
            hospedes.add(new Hospede(10, "Manoel Gomes", "095.547.142-27", "(48) 9780-9850", "manoelgomes@gmail.com"));
            hospedes.add(new Hospede(20, "Ednaldo Pereira", "110.741.248-07", "(49) 9842-5874", "ednaldopereira@hotmail.com"));
            hospedes.add(new Hospede(30, "Anderson Silva", "075.124.159-35", "(51) 9750-4750", "andersonsilva@gmail.com"));
            hospedes.add(new Hospede(40, "Gustavo Kunst", "075.124.159-35", "(51) 9750-4750", "gustavoknust@gmail.com"));
            hospedes.add(new Hospede(50, "Rogério Skynet", "075.124.159-35", "(51) 9750-4750", "rogerioskylab@gmail.com"));
        }
        return hospedes;
    }
}